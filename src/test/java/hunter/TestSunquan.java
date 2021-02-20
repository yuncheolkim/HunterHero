package hunter;

import game.module.battle.Battle;
import game.module.battle.Pos;
import game.module.battle.Side;
import game.module.battle.hero.Sunquan;
import game.module.battle.hero.base.BlankHero;
import org.junit.Test;

/**
 * @author Yunzhe.Jin
 * 2021/2/9 15:31
 */
public class TestSunquan {

    @Test
    public void test1() {
        // 一场战斗
        Battle newBattle = new Battle();
        Common.newHero(newBattle, Side.A, Pos.from(1), BlankHero::new, g -> {
            g.heroStats.hp = (2000);
        });

        Common.newHero(newBattle, Side.B, Pos.from(-2), Sunquan::new, g -> {
            g.heroStats.hp = 2000;
        });

        newBattle.start();

    }
}
