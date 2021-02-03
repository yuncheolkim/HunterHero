package game.hunter.skill;

import game.hunter.Constant;
import game.hunter.Hero;
import game.hunter.Skill;
import game.hunter.action.ActionPoint;
import game.hunter.buff.hero.LiubeiBuff1;
import game.hunter.record.UseSkillRecord;

/**
 * @author Yunzhe.Jin
 * 2021/2/2 15:04
 */
public class LiubeiSkill1 extends Skill {

    public LiubeiSkill1() {
        actionPoint = ActionPoint.回合开始前;
        id = 200004;
        name = "激励";
        cd = Constant.INFINITE;
    }

    @Override
    public UseSkillRecord process(Hero hero) {
        UseSkillRecord record = super.process(hero);

        hero.addBuff(new LiubeiBuff1());

        return record;
    }
}
