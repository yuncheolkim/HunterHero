package game.hunter.buff.effect;

import game.hunter.CalcUtil;
import game.hunter.Hero;
import game.hunter.HeroData;
import game.hunter.buff.Buff;
import game.hunter.buff.BuffEffect;
import game.hunter.damage.DamageInfo;

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

        hero.property.damage += CalcUtil.calcRateAdd(hero.origin.damage, buff.buffVal().i1());
        return true;
    }
}
