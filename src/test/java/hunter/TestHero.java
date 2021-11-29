package hunter;

import game.manager.ConfigManager;
import game.module.battle.Battle;
import game.module.battle.Pos;
import game.module.battle.Side;
import game.module.battle.hero.base.BlankHero;
import game.module.battle.hero.player.DaQiao;
import game.module.battle.hero.player.DianWei;
import game.module.battle.hero.player.ZhouYu;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yunzhe.Jin
 * 2021/11/23 14:25
 */
public class TestHero {
    @Before
    public void before() {
        new ConfigManager().start();
    }

    @Test
    public void testZhouYu() {
        // 一场战斗
        Battle newBattle = new Battle();
        Common.newHero(newBattle, Side.A, Pos.from(1), ZhouYu::new, g -> {
            g.setSpeed(10);
            g.heroStats.hp = 1000;
            g.origin.setDamage(100);
        });

        Common.newHero(newBattle, Side.B, Pos.from(-1), BlankHero::new, g -> {
            g.setSpeed(50);
            g.origin.setDamage(100);
            g.heroStats.hp = 1000;
        });

        newBattle.start();
    }

    @Test
    public void testDaQiao1() {
        // 一场战斗
        Battle newBattle = new Battle();
        Common.newHero(newBattle, Side.A, Pos.from(1), DaQiao::new, g -> {
            g.setSpeed(10);
            g.heroStats.hp = 1000;
            g.origin.setDamage(100);
        });

        Common.newHero(newBattle, Side.B, Pos.from(-1), BlankHero::new, g -> {
            g.setSpeed(50);
            g.origin.setDamage(10);
            g.heroStats.hp = 1000;
        });

        newBattle.start();
    }

    @Test
    public void testDianWei() {
        // 一场战斗
        Battle newBattle = new Battle();
        Common.newHero(newBattle, Side.A, Pos.from(1), DianWei::new, g -> {
            g.setSpeed(10);
            g.heroStats.hp = 1000;
            g.origin.setDamage(100);
        });

        Common.newHero(newBattle, Side.B, Pos.from(-1), BlankHero::new, g -> {
            g.setSpeed(50);
            g.origin.setDamage(100);
            g.heroStats.hp = 1000;
        });

        newBattle.start();
    }

}
