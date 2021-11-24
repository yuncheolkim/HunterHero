package hunter;

import game.manager.ConfigManager;
import game.module.battle.Battle;
import game.module.battle.Pos;
import game.module.battle.Side;
import game.module.battle.hero.base.BlankHero;
import game.module.battle.hero.player.Lusu;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yunzhe.Jin
 * 2021/11/23 14:25
 */
public class TestLusu {
    @Before
    public void before() {
        new ConfigManager().start();
    }

    @Test
    public void test1() {
        // 一场战斗
        Battle newBattle = new Battle();
        Common.newHero(newBattle, Side.A, Pos.from(1), Lusu::new, g -> {
            g.setSpeed(10);
            g.heroStats.hp = 1000;
            g.origin.setDamage(100);
        });

        Common.newHero(newBattle, Side.B, Pos.from(-1), BlankHero::new, g -> {
            g.setSpeed(50);
            g.origin.setDamage(100);
            g.heroStats.hp = 1000;
        });

        Common.newHero(newBattle, Side.B, Pos.from(-2), BlankHero::new, g -> {
            g.setSpeed(50);
            g.origin.setDamage(100);
            g.heroStats.hp = 1000;
        });
        Common.newHero(newBattle, Side.B, Pos.from(-3), BlankHero::new, g -> {
            g.setSpeed(50);
            g.origin.setDamage(100);
            g.heroStats.hp = 1000;
        });
        Common.newHero(newBattle, Side.B, Pos.from(-4), BlankHero::new, g -> {
            g.setSpeed(50);
            g.origin.setDamage(100);
            g.heroStats.hp = 1000;
        });
        newBattle.start();
    }

}
