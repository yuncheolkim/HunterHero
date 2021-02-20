package game.module.battle.hero;

import game.module.battle.Hero;
import game.module.battle.find.MaxHpFindTargetStrategy;
import game.module.battle.find.OneAttackBuffFindTargetStrategy;
import game.module.battle.skill.GuanyuSkill1;
import game.module.battle.skill.GuanyuSkill2;

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
