package game.module.ladder.match;

import com.google.common.collect.TreeMultimap;
import game.base.G;
import game.base.Logs;
import game.base.constants.GameConstants;
import game.game.scene.GameScene;
import game.proto.back.LadderPrepare;
import game.proto.no.No;
import game.utils.DateUtils;
import game.utils.MathUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 排位匹配
 *
 * @author Yunzhe.Jin
 * 2021/8/26 22:32
 */
public class LadderMatchSingleGameScene extends GameScene {
    /**
     * 先手
     */
    TreeMultimap<Integer, MatchInfoMsg> order1Map = TreeMultimap.create();

    /**
     * 后手
     */
    TreeMultimap<Integer, MatchInfoMsg> order2Map = TreeMultimap.create();

    /**
     * 玩家map
     */
    Map<Long, MatchTempData> pmap = new HashMap<>();

    @Override
    protected void process(Object msg) {
        if (msg instanceof MatchInfoMsg) {
            if (pmap.containsKey(((MatchInfoMsg) msg).uid)) {
                return;
            }
            match((MatchInfoMsg) msg);
        } else if (msg instanceof StartWaitMsg) {
            startWaitMsg((StartWaitMsg) msg);
        } else if (msg instanceof MatchCancel) {
            manualCancelMatch((MatchCancel) msg);
        }
    }

    /**
     * 主动取消匹配
     *
     * @param msg
     */
    private void manualCancelMatch(MatchCancel msg) {
        MatchTempData matchTempData = pmap.get(msg);
        if (matchTempData != null) {
            cancelMatch(matchTempData, false);
        }
    }

    /**
     * 定时检查是否有匹配的人
     * 最多5分钟, 5分钟后结束匹配
     *
     * @param msg
     */
    private void startWaitMsg(StartWaitMsg msg) {
        MatchTempData matchTempData = pmap.get(msg.uid);
        if (matchTempData != null) {
            MatchInfoMsg score = targetScore(matchTempData);
            if (score != null) {
                // 找到对手 todo
                findTarget(msg.uid, score.uid);
            } else {
                long now = DateUtils.now();
                long pass = now - matchTempData.info.matchTime;

                if (pass > 5 * 60 * 1000) {
                    cancelMatch(matchTempData, true);
                } else {
                    putToPool(matchTempData);
                }
            }
        }
    }

    /**
     * 找到对手
     */
    private void findTarget(Long uid1, long uid2) {
        Logs.C.info("找到对手:{},{}", uid1, uid2);
        long id = GameConstants.ID_GENERATOR.next();
        MatchTempData d1 = pmap.get(uid1);
        MatchTempData d2 = pmap.get(uid2);
        LadderPrepare prepare1 = LadderPrepare.newBuilder()
                .setAuto(true)
                .setId(id)
                .setType(1)
                .setOrder(d1.info.order)
                .build();
        LadderPrepare prepare2 = LadderPrepare.newBuilder()
                .setAuto(true)
                .setId(id)
                .setType(1)
                .setOrder(d2.info.order)
                .build();

        // 移除数据
        cleanData(uid1);
        cleanData(uid2);

        G.sendToPlayer(uid1, No.LadderPrepareInner.getNumber(), prepare1);
        G.sendToPlayer(uid2, No.LadderPrepareInner.getNumber(), prepare2);
    }

    /**
     * 清理数据
     *
     * @param uid
     */
    private void cleanData(long uid) {
        MatchTempData matchTempData = pmap.get(uid);
        if (matchTempData != null) {
            order1Map.remove(matchTempData.lowScore, matchTempData.info);
            order2Map.remove(matchTempData.lowScore, matchTempData.info);
            pmap.remove(uid);
        }
    }

    /**
     * 取消匹配
     *
     * @param data
     */
    private void cancelMatch(MatchTempData data, boolean inner) {
        // 超过5分钟取消匹配
        long uid = data.info.uid;
        if (inner) {

            G.sendToPlayer(uid, No.LadderCancelInner.getNumber());
        }
        pmap.remove(uid);
        order1Map.remove(data.lowScore, data.info);
        order2Map.remove(data.lowScore, data.info);

    }

    /**
     * 寻找对应玩家
     *
     * @param value
     * @return
     */
    private MatchInfoMsg targetScore(MatchTempData value) {

        int order = value.info.order;

        TreeMultimap<Integer, MatchInfoMsg> find = order1Map;

        if (order == 1) {
            find = order2Map;
        }

        NavigableMap<Integer, Collection<MatchInfoMsg>> scoreMap = find.asMap();
        NavigableMap<Integer, Collection<MatchInfoMsg>> findMap = scoreMap.subMap(value.lowScore - 200, true, value.topScore + 200, true);

        MatchInfoMsg info = null;
        out:
        for (Map.Entry<Integer, Collection<MatchInfoMsg>> en : findMap.entrySet()) {
            Collection<MatchInfoMsg> value1 = en.getValue();
            for (MatchInfoMsg matchInfoMsg : value1) {
                MatchTempData matchTempData = pmap.get(matchInfoMsg.uid);
                if (value.info.uid != matchInfoMsg.uid && matchTempData.check(value)) {
                    info = matchInfoMsg;
                    break out;
                }
            }
        }
        if (info == null) {
            Logs.C.info("not found:{}", value.info);

        }

        return info;
    }

    /**
     * 进行匹配
     *
     * @param msg
     */
    private void match(MatchInfoMsg msg) {
        MatchTempData value = new MatchTempData(msg);

        MatchInfoMsg info = targetScore(value);

        final Long uid = msg.uid;
        if (info == null) {
            // 没有找到对手,放到匹配池
            pmap.put(uid, value);
            putToPool(value);
            return;
        }

        //找到对手
        findTarget(uid, info.uid);
    }

    public LadderMatchSingleGameScene() {
        super();
    }

    /**
     * 放到匹配池里面
     *
     * @param data
     */
    private void putToPool(MatchTempData data) {
        TreeMultimap<Integer, MatchInfoMsg> put = order2Map;

        if (data.info.order == 1) {
            put = order1Map;
        }
        // 先移除
        put.remove(data.lowScore, data.info);
        put.remove(data.topScore, data.info);

        // 计算
        if (data.info.lastWin) {
            if (data.topCount < 12) {
                data.topCount++;
                if (data.topCount % 4 == 0) {
                    data.lowCount--;
                }
            }
        } else {
            if (data.lowCount > -12) {
                data.lowCount--;
                if (data.lowCount % 4 == 0) {
                    data.topCount++;
                }
            }
        }
        data.topScore = data.info.scoreBase + 20 * data.topCount;
        data.lowScore = data.info.scoreBase + 20 * data.lowCount;


        // 放入匹配池
        put.put(data.lowScore, data.info);

        long pass = DateUtils.now() - data.info.matchTime;

        doScheduleMillisecond(MathUtils.clamp(2000, 10000, pass), new StartWaitMsg(data.info.uid));
    }


    @Override
    protected ScheduledExecutorService getSchedule() {
        return G.W.getMatchSchedule();
    }

    //////////////////// msg

    /**
     * 等待匹配
     */
    private static class StartWaitMsg {
        public final Long uid;

        private StartWaitMsg(Long uid) {
            this.uid = uid;
        }
    }

}
