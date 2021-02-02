package game.hunter.hero;

import game.hunter.Hero;
import game.hunter.find.MaxHpFindTargetStrategy;
import game.hunter.find.OneAttackBuffFindTargetStrategy;
import game.hunter.skill.GuanyuSkill1;
import game.hunter.skill.GuanyuSkill2;

/**
 * 关羽
 * @author Yunzhe.Jin
 * 2021/1/11 10:33
 */
public class Guanyu extends Hero {


    public Guanyu() {

        id = 100001;
        addSkill(new GuanyuSkill2());
        addSkill(new GuanyuSkill1());
        targetStrategies.add(new OneAttackBuffFindTargetStrategy());
        targetStrategies.add(new MaxHpFindTargetStrategy());

    }

}
