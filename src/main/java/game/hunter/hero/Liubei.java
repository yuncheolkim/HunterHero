package game.hunter.hero;

import game.hunter.Hero;
import game.hunter.skill.LiubeiSkill1;
import game.hunter.skill.LiubeiSkill2;

/**
 * 刘备
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
