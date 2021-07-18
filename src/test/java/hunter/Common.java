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

    public static <T extends Hero> T newHero(final Battle battle, final Side side, final Pos pos, final Supplier<T> supplier, final Consumer<T> consumer) {
        final T hero = supplier.get();
        hero.setPos(pos);
        hero.setSide(side);
        // 设置数据
        hero.origin = makeData();
        hero.heroStats.hp = hero.origin.getMaxHp();
        hero.setLevel(1);
        hero.setTalentInfo(99999);
        hero.setBattle(battle);
        battle.addHero(hero);
        consumer.accept(hero);
        hero.init();
        return hero;
    }

    private static HeroData makeData() {
        final HeroData data = new HeroData();
        data.setMaxHp(1000);
        data.setDamage(100);
        data.setAvoid(0);
        data.setAvoidBase(100);
        data.setCritical(0);
        data.setCriticalBase(100);
        data.setCriticalDamageRate(100);

        return data;
    }
}
