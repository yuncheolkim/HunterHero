package game.hunter.skill;

import game.hunter.Hero;
import game.hunter.Skill;
import game.hunter.action.ActionPoint;
import game.hunter.buff.hero.CaocaoBuff2;
import game.hunter.record.UseSkillRecord;

/**
 * @author Yunzhe.Jin
 * 2021/2/2 15:04
 */
public class CaocaoSkill2 extends Skill {

    public CaocaoSkill2() {
        actionPoint = ActionPoint.开场;
        id = 200007;
        name = "护驾";
    }

    @Override
    public UseSkillRecord process(Hero hero) {
        UseSkillRecord record = super.process(hero);
        hero.addBuff(new CaocaoBuff2());
        return record;
    }
}
