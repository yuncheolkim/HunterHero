package game.module.ladder.match;

import com.google.common.collect.TreeMultimap;
import game.game.scene.GameScene;

import java.util.HashMap;
import java.util.Map;

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
    Map<Long, MatchInfo> pmap = new HashMap<>();

    @Override
    protected void process(Object msg) {
        if (msg instanceof MatchInfo) {

        }

    }

}
