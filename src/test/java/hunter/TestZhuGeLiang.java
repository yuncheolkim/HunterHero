package hunter;

import game.manager.ConfigManager;
import game.module.battle.Battle;
import game.module.battle.Pos;
import game.module.battle.Side;
import game.module.battle.hero.base.BlankHero;
import game.module.battle.hero.player.ZhuGeLiang;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yunzhe.Jin
 * 2021/11/23 14:25
 */
public class TestZhuGeLiang {
    @Before
    public void before() {
        new ConfigManager().start();
    }

    @Test
    public void test1() {
        // 一场战斗
        Battle newBattle = new Battle();
        Common.newHero(newBattle, Side.A, Pos.from(1), ZhuGeLiang::new, g -> {
            g.setSpeed(10);
            g.heroStats.hp = 1000;
            g.origin.setDamage(100);
        });

        Common.newHero(newBattle, Side.B, Pos.from(16), BlankHero::new, g -> {
            g.setSpeed(50);
            g.origin.setDamage(100);
            g.heroStats.hp = 1000;
        });
        Common.newHero(newBattle, Side.B, Pos.from(17), BlankHero::new, g -> {
            g.setSpeed(50);
            g.origin.setDamage(100);
            g.heroStats.hp = 1000;
        });

        newBattle.start();
    }

}
