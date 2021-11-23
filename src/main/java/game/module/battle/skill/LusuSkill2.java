package game.module.battle.skill;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.hero.BingDongBuff;
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
                    final BingDongBuff addBuff = new BingDongBuff(hero.getId());
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
        data[3] = id;
    }

    public void talent2(final int id) {
        data[2] = id;
    }

    public void talent3(final int id) {
        data[0] = id;
    }

    public void talent4(final int i1, int i2) {
        data[1] += i1;
        data[2] += i2;
    }
}
