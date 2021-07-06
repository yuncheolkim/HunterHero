package game.module.battle.damage;

import game.base.Logs;
import game.module.battle.Hero;
import game.module.battle.HeroData;
import game.module.battle.action.ActionPoint;
import game.utils.CalcUtil;

/**
 * 攻击计算暴击伤害
 *
 * @author Yunzhe.Jin
 * 2021/1/11 16:48
 */
public class CriticalDamageProcess implements DamageProcess {
    @Override
    public boolean process(final Hero hero) {

        hero.getBattle().getDamageInfo().target.processAll(ActionPoint.暴击计算);

        final HeroData processData = hero.fightingData;
        final int rate = processData.getCritical();
        final boolean happened = processData.mustCritical || CalcUtil.happened(rate, rate + processData.getCriticalBase());


        // 暴击伤
        if (happened) {
            final int damage = processData.getDamage();
            final int damageRate = processData.getCriticalDamageRate();
            final DamageInfo damageInfo = hero.getBattle().getDamageInfo();
            damageInfo.sourceCriticalDamage = damageInfo.sourceCriticalDamage + CalcUtil.change100(damage, damageRate);
            hero.processAll(ActionPoint.暴击之后);
            Logs.trace("暴击伤害", rate, processData.getCriticalDamageRate());
        }

        return true;
    }
}
