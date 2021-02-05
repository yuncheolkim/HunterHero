package game.hunter.hero;

import game.hunter.Hero;
import game.hunter.skill.CaocaoSkill1;
import game.hunter.skill.CaocaoSkill2;

/**
 * @author Yunzhe.Jin
 * 2021/2/5 14:55
 */
public class Caocao extends Hero {
    public Caocao() {
        id = 100004;
        addSkill(new CaocaoSkill1());
        addSkill(new CaocaoSkill2());
    }
}
