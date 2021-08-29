package game.module.ladder.match;

import com.google.common.collect.TreeMultimap;
import game.base.G;
import game.base.constants.GameConstants;
import game.game.scene.GameScene;
import game.proto.back.LadderPrepare;
import game.proto.no.No;
import game.utils.DateUtils;

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
            } else {
                long now = DateUtils.now();
                long pass = now - matchTempData.info.matchTime;

                if (pass > 5 * 60 * 1000) {
                    // 超过5分钟取消匹配
                    G.sendToPlayer(msg.uid, No.LadderCancel.getNumber());
                } else {
                    doScheduleMillisecond(pass, msg);
                }
            }
        }
    }

    private MatchInfo targetScore(MatchTempData value) {

        int order = value.info.order;

        TreeMultimap<Integer, MatchInfo> find = order1Map;

        if (order == 1) {
            find = order2Map;
        }

        NavigableMap<Integer, Collection<MatchInfo>> scoreMap = find.asMap();
        Integer top = scoreMap.floorKey(value.topScore);
        Integer low = scoreMap.ceilingKey(value.lowScore);
        Integer targetScore = null;
        if (top != null && low != null) {
            if (value.info.lastWin) {
                targetScore = top;
            } else {
                targetScore = low;
            }
        } else if (top != null) {
            targetScore = top;
        } else if (low != null) {
            targetScore = low;
        }

        if (targetScore != null) {
            Collection<MatchInfo> matchInfos = scoreMap.get(targetScore);
            MatchInfo matchInfo = matchInfos.stream().findFirst().get();
            find.remove(targetScore, matchInfo);

            return matchInfo;
        }
        return null;
    }

    /**
     * 进行匹配
     *
     * @param msg
     */
    private void match(MatchInfo msg) {
        MatchTempData value = new MatchTempData(msg);


        TreeMultimap<Integer, MatchInfo> find = order1Map;
        TreeMultimap<Integer, MatchInfo> put = order2Map;

        if (msg.order == 1) {
            find = order2Map;
            put = order1Map;
        }

        NavigableMap<Integer, Collection<MatchInfo>> scoreMap = find.asMap();
        Integer top = scoreMap.floorKey(value.topScore);
        Integer low = scoreMap.ceilingKey(value.lowScore);
        Integer targetScore = null;
        final long uid = msg.uid;
        if (top != null && low != null) {
            if (value.info.lastWin) {
                targetScore = top;
            } else {
                targetScore = low;
            }
        } else if (top != null) {
            targetScore = top;
        } else if (low != null) {
            targetScore = low;
        } else {
            // 没有找到对手,放到匹配池
            put.put(msg.score, msg);
            pmap.put(uid, value);
            doScheduleSecond(2, new StartWaitMsg(uid));
            return;
        }

        // 找到对手
        Collection<MatchInfo> matchInfos = scoreMap.get(targetScore);
        MatchInfo matchInfo = matchInfos.stream().findFirst().get();
        find.remove(targetScore, matchInfo);

        long id = GameConstants.ID_GENERATOR.next();

        LadderPrepare pre1 = LadderPrepare.newBuilder()
                .setAuto(true)
                .setId(id)
                .setType(1)
                .build();

        G.sendToPlayer(uid, No.LadderPrepare.getNumber(), pre1);
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
