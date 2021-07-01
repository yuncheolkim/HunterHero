package game.module.battle.hero;

import game.module.battle.Hero;
import game.module.battle.skill.LiubeiSkill1;
import game.module.battle.skill.LiubeiSkill2;

/**
 * 刘备
 *
 * @author Yunzhe.Jin
 * 2021/2/3 16:39
 */
public class Liubei extends Hero {

    public Liubei() {
        id = 100003;
        addSkill(new LiubeiSkill1());
        addSkill(new LiubeiSkill2());
    }
}
