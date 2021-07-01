package game.module.battle.hero;

import game.module.battle.Hero;
import game.module.battle.skill.SunquanSkill1;
import game.module.battle.skill.SunquanSkill2;

/**
 * 孙权
 *
 * @author Yunzhe.Jin
 * 2021/2/8 18:53
 */
public class Sunquan extends Hero {

    public Sunquan() {
        id = 100005;

        addSkill(new SunquanSkill1());
        addSkill(new SunquanSkill2());
    }
}
