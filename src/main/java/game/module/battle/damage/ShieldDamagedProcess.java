package game.module.battle.damage;

import game.module.battle.Hero;
import game.module.battle.action.ActionPoint;

/**
 * 受到伤害-计算护盾
 *
 * @author Yunzhe.Jin
 * 2021/1/12 10:49
 */
public class ShieldDamagedProcess implements DamagedProcess {

    @Override
    public boolean process(final DamageInfo info) {
        final Hero target = info.target;

        final int damage = info.allSourceDamage();
        final int shield = target.heroStats.getShield();

        if (shield > 0) {
            final int i = target.heroStats.reduceShield(Math.min(damage, shield));
            info.reduceDamageValue(i);
            target.recordShieldChange(ActionPoint.受到伤害之后, -i);
        }

        return info.allSourceDamage() > 0;
    }
}
