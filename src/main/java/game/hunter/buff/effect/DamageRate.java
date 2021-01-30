package game.hunter.buff.effect;

import game.hunter.CalcUtil;
import game.hunter.Hero;
import game.hunter.HeroData;
import game.hunter.buff.Buff;
import game.hunter.buff.BuffEffect;

/**
 * 增加伤害变化
 *
 * @author Yunzhe.Jin
 * 2021/1/8 16:02
 */
public class DamageRate implements BuffEffect {

    @Override
    public boolean doEffect(Hero hero, Buff buff) {

        HeroData processData = hero.getProcessData();
        HeroData originData = hero.getOriginData();
        processData.setDamage(processData.getDamage() + CalcUtil.calcRateAdd(originData.getDamage(), buff.buffVal().i1()));
        return true;
    }
}
