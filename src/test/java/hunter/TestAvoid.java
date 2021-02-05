package hunter;

import game.hunter.Battle;
import game.hunter.Pos;
import game.hunter.Side;
import game.hunter.hero.Guanyu;
import org.junit.Test;

/**
 * 测试闪避
 * @author Yunzhe.Jin
 * 2021/2/1 14:31
 */
public class TestAvoid {


    @Test
    public void test1() {
        // 一场战斗
        Battle newBattle = new Battle();
        Common.newHero(newBattle, Side.A, Pos.from(1), Guanyu::new, g -> {
            g.heroStats.hp = (2000);
            g.origin.setSpeed(30);
            g.origin.setCritical(5000);
        });

        Common.newHero(newBattle, Side.B, Pos.from(-1), Guanyu::new, g -> {
            g.heroStats.hp = (2000);
            g.origin.setSpeed(20);
            g.origin.setCritical(5000);
            g.origin.setAvoid(2000);
        });

        newBattle.start();

    }


}
