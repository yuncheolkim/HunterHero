package hunter;

import game.manager.ConfigManager;
import game.module.battle.Battle;
import game.module.battle.Pos;
import game.module.battle.Side;
import game.module.battle.hero.JiangWei;
import game.module.battle.hero.base.BlankHero;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yunzhe.Jin
 * 2021/7/3 13:50
 */
public class TestJiangWei {

    @Before
    public void before() {
        new ConfigManager().start();
    }

    @Test
    public void test1() {
        final Battle battle = new Battle();
        Common.newHero(battle, Side.A, Pos.from(1), JiangWei::new, g -> {
            g.setId(1012);
            g.origin.critical = 100;
            g.origin.criticalBase = 100;

        });
        Common.newHero(battle, Side.B, Pos.from(16), BlankHero::new, g -> {
        });

        battle.start();

    }
}
