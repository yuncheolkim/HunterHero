package game.module.battle.skill.common;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;

/**
 * 提高治疗效果
 * 0:提高比例
 *
 * @author Yunzhe.Jin
 * 2021/7/8 16:19
 */
public class IncreaseHealthSkill extends Skill {
    public IncreaseHealthSkill(final int rate) {
        super(1007);
        addActionPoint(ActionPoint.治疗前);
        data[0] = rate;

    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {

    }
}
