package hunter;

import game.manager.ConfigManager;
import game.module.battle.Battle;
import game.module.battle.Pos;
import game.module.battle.Side;
import game.module.battle.hero.player.XiaHouDun;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yunzhe.Jin
 * 2021/7/3 13:50
 */
public class TestXiahouDun {

    @Before
    public void before() {
        new ConfigManager().start();
    }

    @Test
    public void test1() {
        Battle battle = new Battle();
        Common.newHero(battle, Side.A, Pos.from(1), XiaHouDun::new, g -> {
            g.setSpeed(10);
            g.heroStats.hp = 1000;
            g.origin.setDamage(100);
            g.origin.setDef(100);
        });
        Common.newHero(battle, Side.B, Pos.from(16), XiaHouDun::new, g -> {
            g.setSpeed(11);
            g.heroStats.hp = 1000;
            g.origin.setDamage(100);
            g.origin.setDef(100);
        });

        battle.start();

    }
}
