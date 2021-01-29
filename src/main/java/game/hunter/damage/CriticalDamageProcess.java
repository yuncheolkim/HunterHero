package game.hunter.damage;

import game.hunter.CalcUtil;
import game.hunter.Hero;
import game.hunter.HeroData;

/**
 * 攻击计算暴击伤害
 *
 * @author Yunzhe.Jin
 * 2021/1/11 16:48
 */
public class CriticalDamageProcess implements DamageProcess {
    @Override
    public boolean process(Hero hero) {

        HeroData finalData = hero.getFinalData();
        boolean happened = CalcUtil.happened(hero.getBattle().getRandom(), finalData.getCritical(), finalData.getCritical() + 200);

        // 暴击伤害
        if (happened) {
            finalData.setCriticalDamage(finalData.getCriticalDamage() + CalcUtil.calcRateAdd(finalData.getDamage(), finalData.getCriticalDamageRate()));
        }

        return true;
    }
}
