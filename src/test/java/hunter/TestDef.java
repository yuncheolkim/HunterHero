package hunter;

import game.module.battle.Battle;
import game.module.battle.Pos;
import game.module.battle.Side;
import game.module.battle.hero.base.BlankHero;
import org.junit.jupiter.api.Test;

/**
 * 测试闪避
 *
 * @author Yunzhe.Jin
 * 2021/2/1 14:31
 */
public class TestDef {


    @Test
    public void test1() {
        // 一场战斗
        Battle newBattle = new Battle();
        Common.newHero(newBattle, Side.A, Pos.from(1), BlankHero::new, g -> {
            g.heroStats.hp = (2000);
            g.origin.setDef(500);

        });

        Common.newHero(newBattle, Side.B, Pos.from(-1), BlankHero::new, g -> {
            g.heroStats.hp = (2000);

        });

        newBattle.start();

    }


}
