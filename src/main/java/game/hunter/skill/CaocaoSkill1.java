package game.hunter.skill;

import game.hunter.Hero;
import game.hunter.Skill;
import game.hunter.action.ActionPoint;
import game.hunter.buff.hero.CaocaoBuff1;
import game.hunter.record.UseSkillRecord;

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
