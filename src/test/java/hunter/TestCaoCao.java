package hunter;

import game.module.battle.Battle;
import game.module.battle.Pos;
import game.module.battle.Side;
import game.module.battle.hero.player.CaoCao;
import game.module.battle.hero.player.Guanyu;
import game.module.battle.hero.base.BlankHero;
import org.junit.Test;

/**
 * @author Yunzhe.Jin
 * 2021/2/1 14:31
 */
public class TestCaoCao {


    @Test
    public void test1() {
        // 一场战斗
        Battle newBattle = new Battle();
        Common.newHero(newBattle, Side.A, Pos.from(1), Guanyu::new, g -> {
            g.heroStats.hp = (2000);
            g.setSpeed(10);
        });

        Common.newHero(newBattle, Side.B, Pos.from(-1), CaoCao::new, g -> {
            g.setSpeed(50);
            g.heroStats.hp = 2000;
            g.origin.setAvoid(500);
        });

        newBattle.start();

    }

    /**
     * 护驾
     */
    @Test
    public void test2() {
        // 一场战斗
        Battle newBattle = new Battle();
        Common.newHero(newBattle, Side.A, Pos.from(1), BlankHero::new, g -> {
            g.heroStats.hp = (2000);
            g.setSpeed(10);
        });

        Common.newHero(newBattle, Side.B, Pos.from(-1), CaoCao::new, g -> {
            g.setSpeed(50);
            g.heroStats.hp = 2000;
        });

        Common.newHero(newBattle, Side.B, Pos.from(-2), BlankHero::new, g -> {
            g.setSpeed(50);
            g.heroStats.hp = 2000;
            g.origin.setAvoid(500);
        });

        newBattle.start();

    }


}
