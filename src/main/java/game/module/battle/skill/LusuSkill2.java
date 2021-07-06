package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.hero.LusuBuff1;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 攻击施加冰冻buff
 * <p>
 * 0: 施加buff概率
 * 1: 防御比例
 * 2: 伤害加深比例
 * 3: CD时间
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class LusuSkill2 extends Skill {


    public LusuSkill2() {
        super(21);
        actionPoint.put(ActionPoint.出手后, 1);
    }

    @Override
    public void process(final Record record, final ActionPoint point, final Hero hero) {

        switch (point) {
            case 出手后:
                final int addBuffRate = data[0];
                if (CalcUtil.happened100(addBuffRate)) {
                    //加buff
                    final Hero target = hero.getBattle().getDamageInfo().target;
                    final LusuBuff1 addBuff = new LusuBuff1(hero.getId());
                    final int buffDefRate = data[1];
                    final int buffHarmRate = data[2];
                    addBuff.setDefRate(buffDefRate);
                    addBuff.setHarmRate(buffHarmRate);
                    addBuff.SetCd(data[3]);
                    target.addBuff(addBuff);
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