package game.module.battle.hero;

import game.module.battle.Hero;
import game.module.battle.find.BackTargetStrategy;
import game.module.battle.find.FrontTargetStrategy;
import game.module.battle.skill.GuanyuSkill1;
import game.module.battle.skill.GuanyuSkill2;
import game.module.fight.FightService;

/**
 * 关羽
 *
 * @author Yunzhe.Jin
 * 2021/1/11 10:33
 */
public class Guanyu extends Hero {


    public Guanyu() {
        id = 1001;
        targetStrategies.add(new FrontTargetStrategy());
        targetStrategies.add(new BackTargetStrategy());
    }

    @Override
    protected void initTalent() {

        final GuanyuSkill1 skill1 = new GuanyuSkill1();
        final GuanyuSkill2 skill2 = new GuanyuSkill2();

        FightService.talentProcess(id, talentInfo, tdata -> {

            final int id = tdata.id;
            switch (tdata.talentId) {
                case 21:
                    skill1.talent1(id);
                    break;
                case 22:
                    skill1.talent2(id);
                    break;
                case 23:
                    skill2.talent1(id);
                    break;
                case 24:
                    skill1.talent4(id);
                    break;
                case 25:
                    skill1.talent3(id);
                    break;
                case 26:
                    skill2.talent2(id);
                    break;
            }
        });


        addSkill(skill1);
        addSkill(skill2);
    }

}
