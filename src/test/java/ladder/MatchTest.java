package ladder;

import game.base.SingleWork;
import game.module.ladder.match.LadderMatchSingleGameScene;
import game.module.ladder.match.MatchInfo;
import game.utils.DateUtils;
import org.junit.Test;

/**
 * @author Yunzhe.Jin
 * 2021/9/1 22:15
 */
public class MatchTest {

    @Test
    public void test1() {
        LadderMatchSingleGameScene scene = new LadderMatchSingleGameScene();
        scene.setWork(new SingleWork());

        MatchInfo p1 = new MatchInfo();
        p1.uid = 1;
        p1.order = 1;
        p1.score = 1000;
        p1.matchTime = DateUtils.now();
        p1.lastWin = false;
        p1.scoreBase = 1000;


        MatchInfo p2 = new MatchInfo();
        p2.uid = 1;
        p2.order = 1;
        p2.score = 1000;
        p2.matchTime = DateUtils.now();
        p2.lastWin = false;
        p2.scoreBase = 1000;
    }
}
