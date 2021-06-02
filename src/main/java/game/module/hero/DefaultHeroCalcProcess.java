package game.module.hero;

import game.module.hero.calc.*;
import game.proto.data.PlayerHero;

import java.util.LinkedList;

/**
 * @author Yunzhe.Jin
 * 2021/3/8 15:16
 */
public class DefaultHeroCalcProcess {
    private final LinkedList<IHeroCalc> list = new LinkedList<>();

    public DefaultHeroCalcProcess() {
        list.add(new HpHeroCalc());
        list.add(new DamageHeroCalc());
        list.add(new DefHeroCalc());
        list.add(new DefBaseHeroCalc());
        list.add(new AvoidHeroCalc());
        list.add(new AvoidBaseHeroCalc());
        list.add(new CriticalHeroCalc());
        list.add(new CriticalBaseHeroCalc());
        list.add(new CriticalDamageHeroCalc());
        list.add(new SpeedHeroCalc());
    }

    public void doProcess(final PlayerHero old, final PlayerHero.Builder builder) {
        for (final IHeroCalc iHeroCalc : list) {
            iHeroCalc.calc(old, builder);
        }
    }
}
