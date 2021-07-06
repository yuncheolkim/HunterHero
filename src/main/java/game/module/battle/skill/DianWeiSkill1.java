package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.DamageInfo;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 增加敌方失去血量百分比的伤害
 * <p>
 * 0: 伤害比例
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class DianWeiSkill1 extends Skill {


    public DianWeiSkill1() {
        super(45);
        actionPoint.put(ActionPoint.出手前, 1);
    }

    @Override
    public void process(final Record record, final ActionPoint point, final Hero hero) {

        switch (point) {
            case 出手前:
                final DamageInfo damageInfo = hero.getBattle().getDamageInfo();
                final float v = CalcUtil.change100(damageInfo.target.hpLoseRate(), data[0]);
                hero.fightingData.damage += CalcUtil.change100(hero.property.damage, v);
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
