package game.module.battle.hero;

import game.module.battle.Hero;
import game.module.battle.skill.HuanzhongSkill1;

/**
 * 张飞
 *
 * @author Yunzhe.Jin
 * 2021/2/1 14:32
 */
public class Huangzhong extends Hero {

    public Huangzhong() {

        id = 1002;
        addSkill(new HuanzhongSkill1());
    }

}
