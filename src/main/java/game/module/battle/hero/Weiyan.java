package game.module.battle.hero;

import game.module.battle.hero.base.DefaultTargetHero;
import game.module.battle.skill.WeiyanSkill1;
import game.module.battle.skill.WeiyanSkill2;

/**
 * 魏延
 *
 * @author Yunzhe.Jin
 * 2021/6/28 15:45
 */
public class Weiyan extends DefaultTargetHero {

    public Weiyan() {
        super(true);
    }

    @Override
    protected void initTalent() {

        final WeiyanSkill1 weiyanSkill1 = new WeiyanSkill1();
        final WeiyanSkill2 weiyanSkill2 = new WeiyanSkill2();

        addSkill(weiyanSkill1);
        addSkill(weiyanSkill2);

    }
}
