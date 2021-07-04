package game.module.battle.hero;

import game.module.battle.hero.base.DefaultTargetHero;
import game.module.battle.skill.ZhaoyunSkill1;
import game.module.battle.skill.ZhaoyunSkill2;
import game.module.fight.FightService;

/**
 * 赵云
 *
 * @author Yunzhe.Jin
 * 2021/6/19 23:37
 */
public class ZhaoYun extends DefaultTargetHero {

    @Override
    protected void initTalent() {

        final ZhaoyunSkill2 skill2 = new ZhaoyunSkill2();
        final ZhaoyunSkill1 skill1 = new ZhaoyunSkill1();

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
