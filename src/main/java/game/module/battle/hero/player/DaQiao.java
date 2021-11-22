package game.module.battle.hero.player;

import game.module.battle.hero.base.DefaultTargetHero;
import game.module.battle.skill.DaQiaoSkill1;
import game.module.battle.skill.DaQiaoSkill2;
import game.module.battle.skill.DaQiaoSkill3;
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
        final DaQiaoSkill3 skill3 = new DaQiaoSkill3();

        FightService.talentProcess(id, talentInfo, tdata -> {

            final int id = tdata.id;
            switch (tdata.talentId) {
                case 904 -> skill1.talent1(id);
                case 905 -> skill2.talent1(id);
                case 906 -> skill3.talent1(id);
                case 913 -> skill1.talent2(id);
                case 914 -> skill1.talent3(id);
                case 915 -> skill1.talent4(id);
            }
        });
        addSkill(skill1);
        addSkill(skill2);
        addSkill(skill3);
    }
}
