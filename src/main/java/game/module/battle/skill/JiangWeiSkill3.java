package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;

/**
 * 消耗{0}点能量必暴击
 * <p>
 * 0: 暴能条件数量
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class JiangWeiSkill3 extends Skill {

    private int power;

    public JiangWeiSkill3() {
        super(52);
        actionPoint.put(ActionPoint.出手前, 1);
    }

    @Override
    public void process(final Record record, final ActionPoint point, final Hero hero) {

        switch (point) {
            case 出手前:
                if (power >= data[0]) {
                    hero.fightingData.mustCritical = true;
                    power -= data[0];
                }
                break;
        }
    }

    public void addPower(final int v) {
        power += v;
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
