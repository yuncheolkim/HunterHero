package game.hunter.damage;

import game.hunter.CalcUtil;
import game.hunter.Hero;
import game.hunter.HeroData;
import game.hunter.Logs;

/**
 * 攻击计算暴击伤害
 * @author Yunzhe.Jin
 * 2021/1/11 16:48
 */
public class CriticalDamageProcess implements DamageProcess {
    @Override
    public boolean process(Hero hero) {

        HeroData processData = hero.fightingData;

        int rate = processData.getCritical();
        boolean happened = CalcUtil.happened(hero.getBattle().getRandom(), rate, rate + 200);

        // 暴击伤害
        if (happened) {
            int damage = processData.getDamage();
            int damageRate = processData.getCriticalDamageRate();
            hero.damageInfo.sourceCriticalDamage = hero.damageInfo.sourceCriticalDamage + CalcUtil.calcRateAdd(damage, damageRate);

            Logs.trace("暴击伤害", rate, processData.getCriticalDamageRate());
        }

        return true;
    }
}
