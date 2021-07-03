package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 0:增加护甲的比例
 * 1:回合数
 *
 * @author Yunzhe.Jin
 * 2021/6/30 14:10
 */
public class MachaoSkill2 extends Skill {

    public MachaoSkill2() {
        super(16);
        actionPoint.put(ActionPoint.暴击之后, 1);
    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {
        switch (actionPoint) {
            case 暴击之后:
                final int rate = data[0];
                final int round = data[1];
                final int i = CalcUtil.add100(hero.origin.getMaxHp(), rate);
                hero.addShield(round, i, ActionPoint.出手后);
                break;
        }
    }

    public void talent1(final int id) {
        data[0] = ConfigManager.talentDataBox.findById(id).i1;
        data[1] = ConfigManager.talentDataBox.findById(id).i2;
    }
}
