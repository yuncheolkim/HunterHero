package game.module.battle.damage;

import game.module.battle.Hero;
import game.module.battle.HeroData;

/**
 * 受到伤害-计算护甲
 *
 * @author Yunzhe.Jin
 * 2021/1/12 10:49
 */
public class DefDamagedProcess implements DamagedProcess {

    private final int rateBase = 500;

    @Override
    public boolean process(final DamageInfo info) {

        final Hero target = info.target;
        final HeroData fightingData = target.fightingData;
        final int rate = fightingData.getDef() * 100 / (fightingData.getDef() + rateBase);

        if (rate > 0) {
            info.reduceDamage(rate);
        }

        return true;
    }
}
