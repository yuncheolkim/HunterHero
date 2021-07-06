package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;

import java.util.Optional;

/**
 * 攻击施加灼烧buff
 * <p>
 * 0: 施加buff概率
 * 1: 持续时间
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class JiangWeiSkill2 extends Skill {


    public JiangWeiSkill2() {
        super(51);
        actionPoint.put(ActionPoint.暴击之后, 1);
    }

    @Override
    public void process(final Record record, final ActionPoint point, final Hero hero) {

        switch (point) {
            case 暴击之后:
                final Optional<Skill> skill = hero.findSkill(52);
                if (skill.isPresent()) {
                    final JiangWeiSkill3 skill3 = (JiangWeiSkill3) skill.get();
                    skill3.addPower(data[0]);
                }
                break;
        }
    }


    public void talent1(final int id) {
        data[3] = ConfigManager.talentDataBox.findById(id).i1;
    }

    public void talent2(final int id) {
        data[2] = ConfigManager.talentDataBox.findById(id).i1;
    }

    public void talent3(final int id) {
        data[0] = ConfigManager.talentDataBox.findById(id).i1;
    }

    public void talent4(final int id) {
        data[1] += ConfigManager.talentDataBox.findById(id).i1;
        data[2] += ConfigManager.talentDataBox.findById(id).i2;
    }
}
