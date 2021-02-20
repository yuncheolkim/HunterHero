package game.module.battle.skill;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.hero.LiubeiBuff2;
import game.module.battle.record.UseSkillRecord;

/**
 * @author Yunzhe.Jin
 * 2021/2/2 15:04
 */
public class LiubeiSkill2 extends Skill {

    public LiubeiSkill2() {
        actionPoint.put(ActionPoint.开场, 1);

        id = 200005;
        name = "以德服人";
    }

    @Override
    public UseSkillRecord process(ActionPoint point, Hero hero) {
        UseSkillRecord record = super.process(point, hero);

        hero.addBuff(new LiubeiBuff2());

        return record;
    }
}
