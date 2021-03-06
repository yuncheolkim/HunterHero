package hunter;

import game.module.battle.Battle;
import game.module.battle.HeroData;
import game.module.battle.Pos;
import game.module.battle.Side;
import game.module.battle.hero.player.Guanyu;
import org.junit.Test;

/**
 * @author Yunzhe.Jin
 * 2021/1/13 10:43
 */
public class TestBattle {

    @Test
    public void test1() {
        Guanyu g1 = new Guanyu();
        Guanyu g2 = new Guanyu();
        Guanyu g3 = new Guanyu();
        Guanyu g4 = new Guanyu();
        g1.setPos(Pos.from(1));
        g2.setPos(Pos.from(-1));
        g3.setPos(Pos.from(-2));
        g4.setPos(Pos.from(-3));

        init(g1, Side.A);
        init(g2, Side.B);
        init(g3, Side.B);
        init(g4, Side.B);
        g1.heroStats.hp = (5000);
        g1.origin.setCritical(5000);
        g2.heroStats.hp = (500);
        g3.heroStats.hp = (1000);
        g4.heroStats.hp = (500);

        g1.init();
        g2.init();
        g3.init();
        g4.init();


        // 一场战斗
        Battle newBattle = new Battle();
        g1.setBattle(newBattle);
        g2.setBattle(newBattle);
        g3.setBattle(newBattle);
        g4.setBattle(newBattle);

        newBattle.addHero(g1);
        newBattle.addHero(g2);
        newBattle.addHero(g3);
        newBattle.addHero(g4);
        newBattle.start();

    }

    private void init(Guanyu g, Side side) {
        // 设置位置
        // 设置阵营
        g.setSide(side);
        // 设置数据
        g.origin = (makeData());


    }

    private HeroData makeData() {
        HeroData data = new HeroData();
        data.setMaxHp(2000);
        data.setDamage(100);
        data.setDef(100);
        data.setAvoid(0);
        data.setCritical(0);
        data.setCriticalDamageRate(100);

        return data;
    }
}
