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
    TreeMultimap<Integer, MatchInfo> order1Map = TreeMultimap.create();

    /**
     * 后手
     */
    TreeMultimap<Integer, MatchInfo> order2Map = TreeMultimap.create();

    /**
     * 玩家map
     */
    Map<Long, MatchTempData> pmap = new HashMap<>();

    @Override
    protected void process(Object msg) {
        if (msg instanceof MatchInfo) {
            if (pmap.containsKey(((MatchInfo) msg).uid)) {
                return;
            }
            match((MatchInfo) msg);
        } else if (msg instanceof StartWaitMsg) {
            startWaitMsg((StartWaitMsg) msg);
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
            MatchInfo score = targetScore(matchTempData);
            if (score != null) {
                // 找到对手 todo
                findTarget(msg.uid, score.uid);
            } else {
                long now = DateUtils.now();
                long pass = now - matchTempData.info.matchTime;

                if (pass > 5 * 60 * 1000) {
                    cancelMatch(matchTempData);
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
        LadderPrepare prepare = LadderPrepare.newBuilder()
                .setAuto(true)
                .setId(id)
                .setType(1)
                .build();
        // 移除数据
        cleanData(uid1);
        cleanData(uid2);

        G.sendToPlayer(uid1, No.LadderPrepare.getNumber(), prepare);
        G.sendToPlayer(uid2, No.LadderPrepare.getNumber(), prepare);
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
            order1Map.remove(matchTempData.topScore, matchTempData.info);
            order2Map.remove(matchTempData.topScore, matchTempData.info);
            pmap.remove(uid);
        }
    }

    /**
     * 取消匹配
     *
     * @param data
     */
    private void cancelMatch(MatchTempData data) {
        // 超过5分钟取消匹配
        long uid = data.info.uid;
        G.sendToPlayer(uid, No.LadderCancel.getNumber());
        pmap.remove(uid);
        order1Map.remove(data.info.score, data.info);
        order2Map.remove(data.info.score, data.info);

    }

    /**
     * 寻找对应玩家
     *
     * @param value
     * @return
     */
    private MatchInfo targetScore(MatchTempData value) {

        int order = value.info.order;

        TreeMultimap<Integer, MatchInfo> find = order1Map;

        if (order == 1) {
            find = order2Map;
        }

        NavigableMap<Integer, Collection<MatchInfo>> scoreMap = find.asMap();
        Integer top = scoreMap.floorKey(value.topScore);
        Integer low = scoreMap.ceilingKey(value.lowScore);

        if (top == null && low == null) {
            return null;
        } else if (top == null) {
            top = Integer.MAX_VALUE;
        } else if (low == null) {
            low = Integer.MIN_VALUE;
        }
        NavigableMap<Integer, Collection<MatchInfo>> findMap = scoreMap.subMap(low, true, top, true);

        MatchInfo info = null;
        out:
        for (Map.Entry<Integer, Collection<MatchInfo>> en : findMap.entrySet()) {
            Collection<MatchInfo> value1 = en.getValue();
            for (MatchInfo matchInfo : value1) {
                MatchTempData matchTempData = pmap.get(matchInfo.uid);
                if (matchTempData.info.uid != matchInfo.uid && matchTempData.check(value)) {
                    info = matchInfo;
                    break out;
                }
            }
        }

        return info;
    }

    /**
     * 进行匹配
     *
     * @param msg
     */
    private void match(MatchInfo msg) {
        MatchTempData value = new MatchTempData(msg);

        MatchInfo info = targetScore(value);

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
        TreeMultimap<Integer, MatchInfo> put = order2Map;

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
                    data.lowCount++;
                }
            }
        } else {
            if (data.lowCount > -12) {
                data.lowCount--;
                if (data.lowCount % 4 == 0) {
                    data.topCount--;
                }
            }
        }
        data.topScore = data.info.scoreBase + 20 * data.topCount;
        data.lowScore = data.info.scoreBase + 20 * data.lowScore;


        // 放入匹配池
        put.put(data.topScore, data.info);
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
