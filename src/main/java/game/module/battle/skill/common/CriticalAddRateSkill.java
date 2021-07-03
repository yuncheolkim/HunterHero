package game.module.battle.skill.common;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.DamageInfo;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 暴击后暴击伤害提高{0}%
 * 0:提高比例
 *
 * @author Yunzhe.Jin
 * 2021/6/28 15:55
 */
public class CriticalAddRateSkill extends Skill {


    public CriticalAddRateSkill() {
        super(1001);
        actionPoint.put(ActionPoint.出手后, 1);
    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {
        final DamageInfo damageInfo = hero.getBattle().getDamageInfo();
        final int i = damageInfo.allSourceDamage();

        final int value = CalcUtil.add100(i, data[0]);

        if (value > 0) {
            hero.addShield(data[1], value, null);
        }
    }

}
