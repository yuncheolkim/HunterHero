package game.module.ladder.match;

import com.google.common.collect.TreeMultimap;
import game.base.G;
import game.game.scene.GameScene;

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
public class LadderMatchGameScene extends GameScene {
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

    private void startWaitMsg(StartWaitMsg msg) {
    }

    /**
     * 进行匹配
     *
     * @param msg
     */
    private void match(MatchInfo msg) {
        MatchTempData value = new MatchTempData(msg);
        pmap.put(msg.uid, value);

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
            doScheduleSecond(2, new StartWaitMsg(msg.uid));
            return;
        }

        // 找到对手


    }

    @Override
    protected ScheduledExecutorService getSchedule() {
        return G.W.getMatchSchedule();
    }


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
