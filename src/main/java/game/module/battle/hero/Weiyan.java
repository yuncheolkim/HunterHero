package game.module.battle.hero;

import game.module.battle.hero.base.DefaultTargetHero;
import game.module.battle.skill.WeiyanSkill1;
import game.module.battle.skill.WeiyanSkill2;

/**
 * @author Yunzhe.Jin
 * 2021/6/28 15:45
 */
public class Weiyan extends DefaultTargetHero {

    public Weiyan() {
        super(true);
        id = 1004;
    }

    @Override
    protected void initTalent() {

        WeiyanSkill1 weiyanSkill1 = new WeiyanSkill1();
        WeiyanSkill2 weiyanSkill2 = new WeiyanSkill2();

        addSkill(weiyanSkill1);
        addSkill(weiyanSkill2);

    }
}
