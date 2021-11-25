package game.module.battle.hero.player;

import game.module.battle.hero.base.DefaultTargetHero;
import game.module.battle.skill.MachaoSkill1;
import game.module.battle.skill.MachaoSkill2;
import game.module.battle.skill.common.CriticalAddRateSkill;
import game.module.fight.FightService;

/**
 * 马超 - 6
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

        FightService.talentProcess(id, talentInfo, tdata -> {

            final int id = tdata.id;
            switch (tdata.talentId) {
                case 404 -> skill1.talent1(id);
                case 406 -> skill2.talent1(id);
                case 413 -> addSkill(new CriticalAddRateSkill());
                case 414 -> skill1.talent2(id);
                case 415 -> skill2.talent2(id);
            }
        });


        addSkill(skill1);
        addSkill(skill2);
    }
}
