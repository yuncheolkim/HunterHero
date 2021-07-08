package game.module.battle.skill.common;

import game.base.Logs;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;

import static game.module.battle.action.ActionPoint.受到伤害前;

/**
 * 减少暴击伤害
 * 0:减少比例
 *
 * @author Yunzhe.Jin
 * 2021/7/5 16:43
 */
public class ReduceCriticalDamageSkill extends Skill {

    public ReduceCriticalDamageSkill(final int rate) {
        super(1006);
        addActionPoint(受到伤害前);
        setRate(rate);
    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {
        switch (actionPoint) {
            case 受到伤害前:
                Logs.trace("减少暴击伤害", data[0] / 100.f);
                hero.getBattle().getDamageInfo().reduceCriticalDamage(data[0] / 100.0f);
                break;
        }

    }

    public void setRate(final int rate) {
        data[0] = rate;
    }
}
