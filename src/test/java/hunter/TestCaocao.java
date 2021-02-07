package hunter;

import game.hunter.Battle;
import game.hunter.Pos;
import game.hunter.Side;
import game.hunter.hero.Caocao;
import game.hunter.hero.Guanyu;
import org.junit.Test;

/**
 * @author Yunzhe.Jin
 * 2021/2/1 14:31
 */
public class TestCaocao {


    @Test
    public void test1() {
        // 一场战斗
        Battle newBattle = new Battle();
        Common.newHero(newBattle, Side.A, Pos.from(1), Guanyu::new, g -> {
            g.heroStats.hp = (2000);
            g.origin.setSpeed(10);
        });

        Common.newHero(newBattle, Side.B, Pos.from(-1), Caocao::new, g -> {
            g.origin.setSpeed(50);
            g.heroStats.hp = 2000;
            g.origin.setAvoid(500);
        });

        newBattle.start();

    }


}
