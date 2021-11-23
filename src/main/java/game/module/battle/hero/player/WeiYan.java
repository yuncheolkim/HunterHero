package game.module.battle.hero.player;

import game.module.battle.hero.base.DefaultTargetHero;
import game.module.battle.skill.WeiyanSkill1;
import game.module.battle.skill.WeiyanSkill2;
import game.module.battle.skill.common.AttackShieldSkill;
import game.module.battle.skill.common.ReduceDamageSkill;
import game.module.fight.FightService;

/**
 * 魏延 - 4
 *
 * @author Yunzhe.Jin
 * 2021/6/28 15:45
 */
public class WeiYan extends DefaultTargetHero {

    public WeiYan() {
    }

    @Override
    protected void initTalent() {

        final WeiyanSkill1 skill1 = new WeiyanSkill1();
        final WeiyanSkill2 skill2 = new WeiyanSkill2();
        FightService.talentProcess(id, talentInfo, tdata -> {
            switch (tdata.talentId) {
                case 304 -> addSkill(new AttackShieldSkill());
                case 305 -> skill1.talent1(tdata.i1);
                case 306 -> skill2.talent1(tdata.i1);
                case 313 -> skill1.talent2();
                case 314 -> skill1.talent3();
                case 315 -> addSkill(new ReduceDamageSkill());
            }
        });
        addSkill(skill1);
        addSkill(skill2);
    }

}
