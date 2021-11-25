package game.module.battle.hero.player;

import game.module.battle.hero.base.DefaultTargetHero;
import game.module.battle.skill.ZhouyuSkill1;
import game.module.battle.skill.ZhouyuSkill2;
import game.module.fight.FightService;

/**
 * 周瑜 - 7
 *
 * @author Yunzhe.Jin
 * 2021/7/2 21:27
 */
public class ZhouYu extends DefaultTargetHero {


    @Override
    protected void initTalent() {
        final ZhouyuSkill1 skill1 = new ZhouyuSkill1();
        final ZhouyuSkill2 skill2 = new ZhouyuSkill2();

        FightService.talentProcess(id, talentInfo, tdata -> {

            final int id = tdata.id;
            switch (tdata.talentId) {
                case 704 -> skill1.talent1(id);
                case 705 -> skill2.talent1(id);
                case 706 -> skill2.talent2(id);
                case 713 -> skill1.talent2(id);
                case 714 -> skill1.talent3(id);
                case 715 -> skill2.talent3(id);
            }
        });
        addSkill(skill1);
        addSkill(skill2);
    }
}
