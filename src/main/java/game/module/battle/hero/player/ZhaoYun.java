package game.module.battle.hero.player;

import game.module.battle.hero.base.DefaultTargetHero;
import game.module.battle.skill.ZhaoyunSkill1;
import game.module.battle.skill.ZhaoyunSkill2;
import game.module.fight.FightService;

/**
 * 赵云 - 3
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
            final int i1 = tdata.i1;
            switch (tdata.talentId) {
                case 33 -> skill1.talent1(i1);
                case 34 -> skill1.talent2(i1);
                case 36 -> skill1.talent3(i1);
                case 38 -> skill1.talent4(i1);
                case 37 -> skill2.talent1(i1);
                case 35 -> skill2.talent2(i1);
            }
        });
        addSkill(skill1);
        addSkill(skill2);
    }
}
