package game.hunter.hero;

import game.hunter.Hero;
import game.hunter.skill.SunquanSkill1;
import game.hunter.skill.SunquanSkill2;

/**
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
