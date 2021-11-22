package hunter;

import game.module.battle.Battle;
import game.module.battle.Pos;
import game.module.battle.Side;
import game.module.battle.hero.player.SunQuan;
import game.module.battle.hero.base.BlankHero;
import org.junit.Test;

/**
 * @author Yunzhe.Jin
 * 2021/2/9 15:31
 */
public class TestSunQuan {

    @Test
    public void test1() {
        // 一场战斗
        Battle newBattle = new Battle();
        Common.newHero(newBattle, Side.A, Pos.from(1), BlankHero::new, g -> {
        });
        Common.newHero(newBattle, Side.A, Pos.from(2), BlankHero::new, g -> {
        });
        Common.newHero(newBattle, Side.A, Pos.from(3), BlankHero::new, g -> {
        });


        Common.newHero(newBattle, Side.B, Pos.from(-2), SunQuan::new, g -> {
        });

        newBattle.start();

    }
}
