package game.hunter.skill;

import game.hunter.Constant;
import game.hunter.Hero;
import game.hunter.Skill;
import game.hunter.action.ActionPoint;
import game.hunter.buff.hero.ZhangfeiBuff1;
import game.hunter.record.UseSkillRecord;

/**
 * @author Yunzhe.Jin
 * 2021/2/2 15:04
 */
public class ZhangfeiSkill1 extends Skill {

    public ZhangfeiSkill1() {
        actionPoint.put(ActionPoint.开场, 1);
        id = 200001;
        name = "ZhangfeiSkill1";
        cd = Constant.INFINITE;
    }

    @Override
    public UseSkillRecord process(ActionPoint point, Hero hero) {
        UseSkillRecord record = super.process(point, hero);

        hero.addBuff(new ZhangfeiBuff1());

        return record;
    }
}