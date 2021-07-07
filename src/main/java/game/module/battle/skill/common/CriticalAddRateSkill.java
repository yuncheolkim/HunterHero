package game.module.battle.skill.common;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;

/**
 * 暴击后暴击伤害提高{0}%
 * 0:提高比例
 *
 * @author Yunzhe.Jin
 * 2021/6/28 15:55
 */
public class CriticalAddRateSkill extends Skill {
    /**
     * 是否发生过暴击
     */
    private boolean happenCri;

    public CriticalAddRateSkill() {
        super(1003);
        actionPoint.put(ActionPoint.暴击后, 1);
        actionPoint.put(ActionPoint.出手前, 1);

    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {

        switch (actionPoint) {
            case 暴击后:
                happenCri = true;
                break;
            case 出手前:
                final int datum = data[0];
                if (happenCri) {
                    hero.fightingData.criticalDamageRate += data[0];
                    happenCri = false;
                }

                break;
        }

    }

}
