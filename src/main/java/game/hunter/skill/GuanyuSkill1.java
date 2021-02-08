package game.hunter.skill;

import game.hunter.Constant;
import game.hunter.Hero;
import game.hunter.Skill;
import game.hunter.action.ActionPoint;
import game.hunter.buff.OneAttackBuff;
import game.hunter.record.UseSkillRecord;

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
    public UseSkillRecord process(ActionPoint point, Hero hero) {
        UseSkillRecord record = super.process(point, hero);
        hero.addBuff(new OneAttackBuff(hero.damageInfo.target));
        return record;
    }


}
