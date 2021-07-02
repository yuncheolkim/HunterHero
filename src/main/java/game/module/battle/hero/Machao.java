package game.module.battle.hero;

import game.module.battle.hero.base.DefaultTargetHero;
import game.module.battle.skill.MachaoSkill1;
import game.module.battle.skill.MachaoSkill2;

/**
 * 马超
 *
 * @author Yunzhe.Jin
 * 2021/6/28 21:46
 */
public class Machao extends DefaultTargetHero {
    public Machao() {
        super(true);
    }

    @Override
    protected void initTalent() {
        final MachaoSkill1 skill1 = new MachaoSkill1();
        final MachaoSkill2 skill2 = new MachaoSkill2();

        //region todo test
        origin.setCritical(origin.getCriticalBase() * 20);
        //endregion

        addSkill(skill1);
        addSkill(skill2);
    }
}
