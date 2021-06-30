package game.module.battle.hero;

import game.module.battle.action.ActionPoint;
import game.module.battle.buff.hero.MachaoBuff1;
import game.module.battle.hero.base.DefaultTargetHero;
import game.module.battle.skill.MachaoSkill2;

/**
 * @author Yunzhe.Jin
 * 2021/6/28 21:46
 */
public class Machao extends DefaultTargetHero {
    public Machao() {
        super(true);
    }

    @Override
    protected void initTalent() {
        final MachaoBuff1 buff1 = new MachaoBuff1();
        final MachaoSkill2 skill2 = new MachaoSkill2();

        origin.setCritical(origin.getCriticalBase() * 2);

        addAction(ActionPoint.开场, hero -> {
            hero.addBuff(buff1);
        });
        addSkill(skill2);
    }
}
