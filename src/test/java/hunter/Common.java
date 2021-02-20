package hunter;

import game.module.battle.*;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author Yunzhe.Jin
 * 2021/2/2 16:08
 */
public class Common {
    public static int id = 0;

    public static <T extends Hero> T newHero(Battle battle, Side side, Pos pos, Supplier<T> supplier, Consumer<T> consumer) {
        T hero = supplier.get();
        hero.setPos(pos);
        // 设置位置
        // 设置阵营
        hero.setSide(side);
        // 设置数据
        hero.origin = makeData();

        hero.setBattle(battle);
        if (side == Side.A) {
            battle.getSideAhero().add(hero);
        } else {
            battle.getSideBhero().add(hero);
        }

        consumer.accept(hero);
        hero.init();
        return hero;
    }

    private static HeroData makeData() {
        HeroData data = new HeroData();
        data.setMaxHp(2000);
        data.setDamage(100);
        data.setAvoid(0);
        data.setCritical(0);
        data.setCriticalDamageRate(0);
        data.setSpeed(100);

        return data;
    }
}
