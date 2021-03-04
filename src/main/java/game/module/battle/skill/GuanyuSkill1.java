package game.module.battle.skill;

import game.module.battle.Constant;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.OneAttackBuff;
import game.module.battle.record.Record;

/**
 * 关羽技能1
 * @author Yunzhe.Jin
 * 2021/1/11 10:30
 */
public class GuanyuSkill1 extends Skill {

    public GuanyuSkill1() {
        id = 200002;
        name = "GuanyuSkill1";
        actionPoint.put(ActionPoint.出手后, 1);
        priority = 1;
        cd = Constant.INFINITE;

    }

    @Override
    public Record process(ActionPoint point, Hero hero) {
        Record record = super.process(point, hero);
        hero.addBuff(new OneAttackBuff(hero.damageInfo.target));
        return record;
    }


}
