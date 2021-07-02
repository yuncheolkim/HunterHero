package game.module.battle.hero;

import game.module.battle.Hero;
import game.module.battle.skill.LusuSkill1;
import game.module.battle.skill.LusuSkill2;
import game.module.battle.skill.LusuSkill3;

/**
 * 鲁肃
 *
 * @author Yunzhe.Jin
 * 2021/6/28 21:43
 */
public class Lusu extends Hero {

    public Lusu() {
    }

    @Override
    protected void initTalent() {
        final LusuSkill1 skill1 = new LusuSkill1();
        final LusuSkill2 skill2 = new LusuSkill2();
        final LusuSkill3 skill3 = new LusuSkill3();

        addSkill(skill1);
        addSkill(skill2);
        addSkill(skill3);
    }
}
