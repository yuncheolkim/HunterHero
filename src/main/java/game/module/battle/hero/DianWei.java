package game.module.battle.hero;

import game.module.battle.hero.base.DefaultTargetHero;
import game.module.battle.skill.DianWeiSkill1;
import game.module.battle.skill.common.DamageBloodSkill;
import game.module.battle.skill.common.ReduceCriticalSkill;
import game.module.fight.FightService;

/**
 * @author Yunzhe.Jin
 * 2021/7/2 21:26
 */
public class DianWei extends DefaultTargetHero {


    @Override
    protected void initTalent() {
        final DianWeiSkill1 skill1 = new DianWeiSkill1();
        final ReduceCriticalSkill skill2 = new ReduceCriticalSkill();
        final DamageBloodSkill skill3 = new DamageBloodSkill();
        skill2.setRate(50);
        skill3.setBloodRate(20);
        FightService.talentProcess(id, talentInfo, tdata -> {

            final int id = tdata.id;
            switch (tdata.talentId) {
                case 33:
                    skill1.talent1(id);
                    break;
                case 34:
                    skill1.talent2(id);
                    break;
                case 35:
                    break;
                case 36:
                    skill1.talent3(id);
                    break;
                case 37:
                    break;
                case 38:
                    skill1.talent4(id);
                    break;
            }
        });
        addSkill(skill1);
        addSkill(skill2);
        addSkill(skill3);
    }
}
