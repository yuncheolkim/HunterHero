package game.module.battle.hero;

import game.module.battle.hero.base.DefaultTargetHero;
import game.module.battle.skill.DianWeiSkill1;
import game.module.battle.skill.common.*;
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
                case 1004:
                    skill1.talent1(id);
                    break;
                case 1005:
                    skill2.setRate(tdata.i1);
                    break;
                case 1006:
                    addSkill(new ReduceCriticalDamageSkill(tdata.i1));
                    break;
                case 1013:
                    skill1.talent2(tdata.i1, tdata.i2);
                    break;
                case 1014:
                    addSkill(new IncreaseHealthSkill(tdata.i1));
                    break;
                case 1015:
                    addSkill(new ReduceDamageSkill(tdata.i1));
                    break;
            }
        });
        addSkill(skill1);
        addSkill(skill2);
        addSkill(skill3);
    }
}
