package game.module.battle.skill.common;

import game.base.Logs;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.DamageInfo;
import game.module.battle.record.Record;

/**
 * 减少伤害
 * 0:伤害百分比
 *
 * @author Yunzhe.Jin
 * 2021/7/3 19:41
 */
public class ReduceDamageSkill extends Skill {
    public ReduceDamageSkill() {
        super(1002);
        actionPoint.put(ActionPoint.受到伤害之前, 1);
    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {
        final DamageInfo damageInfo = hero.getBattle().getDamageInfo();
        if (damageInfo.origin == hero) {
            return;
        }
        switch (actionPoint) {
            case 受到伤害之前:
                Logs.trace("ReduceDamageSkill", data[0] / 100.f);
                hero.getBattle().getDamageInfo().reduceDamage(data[0] / 100.0f);
                break;
        }

    }
}
