package game.module.battle.damage;

import game.module.battle.Hero;
import game.module.battle.HeroData;
import game.utils.CalcUtil;

/**
 * 受到伤害-计算护甲
 *
 * @author Yunzhe.Jin
 * 2021/1/12 10:49
 */
public class DefDamagedProcess implements DamagedProcess {

    @Override
    public boolean process(final DamageInfo info) {

        final Hero target = info.target;
        final HeroData fightingData = target.property;
        int def = CalcUtil.calcRateSub(fightingData.getDef(), info.source.fightingData.getDefReduce() / 10000.0f);
        final float rate = CalcUtil.calcRateProperty1(def, fightingData.getDefBase());

        if (rate > 0) {
            info.reduceDamage(rate);
        }

        return true;
    }
}
