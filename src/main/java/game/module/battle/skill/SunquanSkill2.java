package game.module.battle.skill;

import game.module.battle.Constant;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.UseSkillRecord;

/**
 * 受到的伤害减少20%
 * @author Yunzhe.Jin
 * 2021/2/9 10:18
 */
public class SunquanSkill2 extends Skill {

    private int rate = 20;

    public SunquanSkill2() {
        actionPoint.put(ActionPoint.受到伤害之前, 1);
        id = 200009;
        name = "威慑";
        cd = Constant.INFINITE;
    }


    @Override
    public UseSkillRecord process(ActionPoint actionPoint, Hero hero) {
        UseSkillRecord process = super.process(actionPoint, hero);

        hero.damageInfo.reduceDamage(rate);

        return process;
    }
}
