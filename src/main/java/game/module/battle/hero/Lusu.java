package game.module.battle.hero;

import game.module.battle.Hero;
import game.module.battle.skill.LusuSkill1;
import game.module.battle.skill.LusuSkill2;
import game.module.battle.skill.LusuSkill3;
import game.module.fight.FightService;

/**
 * 鲁肃
 *
 * @author Yunzhe.Jin
 * 2021/6/28 21:43
 */
public class Lusu extends Hero {

    @Override
    protected void initTalent() {
        final LusuSkill1 skill1 = new LusuSkill1();
        final LusuSkill2 skill2 = new LusuSkill2();
        final LusuSkill3 skill3 = new LusuSkill3();
        FightService.talentProcess(id, talentInfo, tdata -> {

            final int id = tdata.id;
            switch (tdata.talentId) {
                case 504:
                    skill1.talent1(id);
                    break;
                case 505:
                    skill2.talent1(id);
                    break;
                case 506:
                    skill2.talent2(id);
                    break;
                case 513:
                    skill2.talent3(id);
                    break;
                case 514:
                    skill2.talent4(id);
                    break;
                case 515:
                    skill3.talent1(id);
                    break;
            }
        });
        addSkill(skill1);
        addSkill(skill2);
        addSkill(skill3);
    }
}
