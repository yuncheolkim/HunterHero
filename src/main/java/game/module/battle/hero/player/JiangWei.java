package game.module.battle.hero.player;

import game.module.battle.hero.base.DefaultTargetHero;
import game.module.battle.skill.JiangWeiSkill1;
import game.module.battle.skill.JiangWeiSkill2;
import game.module.battle.skill.JiangWeiSkill3;
import game.module.fight.FightService;

/**
 * 姜维 - 1012
 *
 * @author Yunzhe.Jin
 * 2021/7/2 21:27
 */
public class JiangWei extends DefaultTargetHero {

    @Override
    protected void initTalent() {
        final JiangWeiSkill1 skill1 = new JiangWeiSkill1();
        final JiangWeiSkill2 skill2 = new JiangWeiSkill2();
        final JiangWeiSkill3 skill3 = new JiangWeiSkill3();

        FightService.talentProcess(id, talentInfo, tdata -> {
            switch (tdata.talentId) {
                case 1104 -> skill1.talent1(tdata.i1);
                case 1105 -> skill2.talent1(tdata.i1);
                case 1106 -> skill3.talent1(tdata.i1);
                case 1113 -> skill1.talent2(tdata.i1);
                case 1114 -> skill1.talent3(tdata.i1);
                case 1115 -> skill3.talent2(tdata.i1);
            }
        });
        addSkill(skill1);
        addSkill(skill2);
        addSkill(skill3);
    }
}
