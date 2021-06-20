package game.module.battle.buff.effect;

import game.module.battle.Hero;
import game.module.battle.buff.Buff;
import game.module.battle.buff.BuffEffect;
import game.utils.CalcUtil;

/**
 * 增加伤害变化
 * i1 伤害量
 *
 * @author Yunzhe.Jin
 * 2021/1/8 16:02
 */
public class DamageRate implements BuffEffect {

    @Override
    public boolean doEffect(Hero hero, Buff buff) {

        hero.property.damage += CalcUtil.calcRateChangeValue(hero.origin.damage, buff.buffVal().i1());
        return true;
    }
}
