package hunter;

import game.hunter.Battle;
import game.hunter.Pos;
import game.hunter.Side;
import game.hunter.hero.Guanyu;
import game.hunter.hero.Zhangfei;
import org.junit.Test;

/**
 * @author Yunzhe.Jin
 * 2021/2/1 14:31
 */
public class TestZhangfei {


    @Test
    public void test1() {
        // 一场战斗
        Battle newBattle = new Battle();
        Common.newHero(newBattle, Side.A, Pos.from(1), Guanyu::new, g -> {
            g.heroStats.hp = (2000);
            g.origin.setSpeed(10);
            g.origin.setCritical(5000);
        });

        Common.newHero(newBattle, Side.B, Pos.from(-1), Zhangfei::new, g -> {
            g.origin.setSpeed(50);
            g.heroStats.hp = 2000;
        });

        newBattle.start();

    }


}
