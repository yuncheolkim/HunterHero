package game.module.battle.hero;

import game.module.battle.hero.base.DefaultTargetHero;
import game.module.battle.skill.DaQiaoSkill1;
import game.module.battle.skill.DaQiaoSkill2;
import game.module.fight.FightService;

/**
 * @author Yunzhe.Jin
 * 2021/7/2 21:27
 */
public class DaQiao extends DefaultTargetHero {


    @Override
    protected void initTalent() {
        final DaQiaoSkill1 skill1 = new DaQiaoSkill1();
        final DaQiaoSkill2 skill2 = new DaQiaoSkill2();

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
                    skill2.talent2(id);
                    break;
                case 36:
                    skill1.talent3(id);
                    break;
                case 37:
                    skill2.talent1(id);
                    break;
                case 38:
                    skill1.talent4(id);
                    break;
            }
        });
        addSkill(skill1);
        addSkill(skill2);
    }
}
