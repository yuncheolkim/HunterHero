package ladder;

import game.base.SingleWork;
import game.module.ladder.match.LadderMatchSingleGameScene;
import game.module.ladder.match.MatchInfoMsg;
import game.utils.DateUtils;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author Yunzhe.Jin
 * 2021/9/1 22:15
 */
public class MatchTest {

    @Test
    public void test1() throws InterruptedException {
        LadderMatchSingleGameScene scene = new LadderMatchSingleGameScene();
        SingleWork work = new SingleWork();
        scene.setWork(work);
        work.start();

        MatchInfoMsg p1 = new MatchInfoMsg();
        p1.uid = 1;
        p1.order = 1;
        p1.score = 1000;
        p1.matchTime = DateUtils.now();
        p1.lastWin = false;
        p1.scoreBase = 1000;


        MatchInfoMsg p2 = new MatchInfoMsg();
        p2.uid = 2;
        p2.order = 2;
        p2.score = 1000;
        p2.matchTime = DateUtils.now();
        p2.lastWin = false;
        p2.scoreBase = 1000;

        scene.tell(p1);
        scene.tell(p2);
        TimeUnit.HOURS.sleep(1);
    }

}
