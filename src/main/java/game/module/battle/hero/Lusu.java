package game.module.battle.hero;

import game.module.battle.Hero;
import game.module.battle.skill.LusuSkill1;

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


        addSkill(skill1);
    }
}
