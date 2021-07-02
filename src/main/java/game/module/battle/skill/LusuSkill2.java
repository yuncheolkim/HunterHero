package game.module.battle.skill;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.hero.LusuBuff1;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 攻击施加冰冻buff
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
                    final Hero target = hero.damageInfo.target;
                    final LusuBuff1 addBuff = new LusuBuff1();
                    final int buffDefRate = data[1];
                    final int buffHarmRate = data[2];
                    addBuff.setDefRate(buffDefRate);
                    addBuff.setHarmRate(buffHarmRate);
                    target.addBuff(addBuff);
                }
                break;
        }

    }
}
