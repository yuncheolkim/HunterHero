package game.module.battle.hero;

import game.module.battle.Hero;
import game.module.battle.skill.CaocaoSkill1;
import game.module.battle.skill.CaocaoSkill2;

/**
 * @author Yunzhe.Jin
 * 2021/2/5 14:55
 */
public class Caocao extends Hero {
    public static final int ID = 100004;

    public Caocao() {
        id = ID;
        addSkill(new CaocaoSkill1());
        addSkill(new CaocaoSkill2());
    }
}
