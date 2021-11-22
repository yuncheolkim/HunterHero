package game.module.battle.hero;

import game.module.battle.hero.base.DefaultTargetHero;
import game.module.battle.skill.GuanyuSkill1;
import game.module.battle.skill.GuanyuSkill2;
import game.module.fight.FightService;

/**
 * 关羽
 *
 * @author Yunzhe.Jin
 * 2021/1/11 10:33
 */
public class Guanyu extends DefaultTargetHero {


    public Guanyu() {
    }

    @Override
    protected void initTalent() {

        final GuanyuSkill1 skill1 = new GuanyuSkill1();
        final GuanyuSkill2 skill2 = new GuanyuSkill2();

        FightService.talentProcess(id, talentInfo, tdata -> {

            final int id = tdata.id;
            switch (tdata.talentId) {
                case 21 -> skill1.talent1(id);
                case 22 -> skill1.talent2(id);
                case 23 -> skill2.talent1(id);
                case 24 -> skill1.talent4(id);
                case 25 -> skill1.talent3(id);
                case 26 -> skill2.talent2(id);
            }
        });


        addSkill(skill1);
        addSkill(skill2);
    }

}
