package hunter;

import game.module.battle.Battle;
import game.module.battle.Pos;
import game.module.battle.Side;
import game.module.battle.hero.player.Guanyu;
import game.module.battle.hero.player.Liubei;
import game.module.battle.hero.player.Zhangfei;
import org.junit.Test;

/**
 * @author Yunzhe.Jin
 * 2021/2/4 15:10
 */
public class TestLiubei {

    @Test
    public void test1() {
        // 一场战斗
        Battle newBattle = new Battle();
        Common.newHero(newBattle, Side.A, Pos.from(1), Guanyu::new, g -> {
            g.heroStats.hp = (2000);
            g.setSpeed(10);
            g.origin.setCritical(5000);
        });
        Common.newHero(newBattle, Side.A, Pos.from(2), Liubei::new, g -> {
            g.heroStats.hp = (2000);
            g.setSpeed(10);
        });

        Common.newHero(newBattle, Side.B, Pos.from(-1), Zhangfei::new, g -> {
            g.setSpeed(50);
            g.heroStats.hp = 5000;
        });

        newBattle.start();
    }

    /**
     * 以德服人test
     */
    @Test
    public void test2() {
        // 一场战斗
        Battle newBattle = new Battle();
        Common.newHero(newBattle, Side.A, Pos.from(2), Liubei::new, g -> {
            g.heroStats.hp = (2000);
        });

        Common.newHero(newBattle, Side.B, Pos.from(-1), Zhangfei::new, g -> {
            g.heroStats.hp = 5000;
            g.origin.setDamage(300);
            g.setSpeed(200);
        });

        newBattle.start();
    }
}
