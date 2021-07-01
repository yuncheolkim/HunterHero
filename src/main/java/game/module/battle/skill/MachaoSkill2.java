package game.module.battle.skill;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * @author Yunzhe.Jin
 * 2021/6/30 14:10
 */
public class MachaoSkill2 extends Skill {

    private int round = 1;

    private int rate = 20;

    public MachaoSkill2() {
        id = 16;
        actionPoint.put(ActionPoint.暴击之后, 1);
    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {
        switch (actionPoint) {
            case 暴击之后:
                final int i = CalcUtil.add100(hero.origin.getMaxHp(), rate);
                hero.addShield(round, i, ActionPoint.出手后);
                break;
        }
    }

}
