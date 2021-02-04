package game.hunter.skill;

import game.hunter.Hero;
import game.hunter.Skill;
import game.hunter.action.ActionPoint;
import game.hunter.buff.hero.LiubeiBuff2;
import game.hunter.record.UseSkillRecord;

/**
 * @author Yunzhe.Jin
 * 2021/2/2 15:04
 */
public class LiubeiSkill2 extends Skill {

    public LiubeiSkill2() {
        actionPoint = ActionPoint.开场;
        id = 200005;
        name = "以德服人";
    }

    @Override
    public UseSkillRecord process(Hero hero) {
        UseSkillRecord record = super.process(hero);

        hero.addBuff(new LiubeiBuff2());

        return record;
    }
}
