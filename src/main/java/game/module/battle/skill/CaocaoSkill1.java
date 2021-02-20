package game.module.battle.skill;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.hero.CaocaoBuff1;
import game.module.battle.record.UseSkillRecord;

/**
 * @author Yunzhe.Jin
 * 2021/2/2 15:04
 */
public class CaocaoSkill1 extends Skill {

    public CaocaoSkill1() {
        actionPoint.put(ActionPoint.开场, 1);
        id = 200006;
        name = "奸雄";
    }

    @Override
    public UseSkillRecord process(ActionPoint point, Hero hero) {
        UseSkillRecord record = super.process(point, hero);

        hero.addBuff(new CaocaoBuff1());

        return record;
    }
}
