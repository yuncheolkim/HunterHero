package game.module.battle.hero.player;

import game.module.battle.hero.base.DefaultTargetHero;
import game.module.battle.skill.XiaHouDunSkill1;
import game.module.battle.skill.XiaHouDunSkill2;
import game.module.battle.skill.common.ReduceDamageSkill;
import game.module.fight.FightService;

/**
 * 夏侯惇 - 7
 *
 * @author Yunzhe.Jin
 * 2021/6/28 21:48
 */
public class XiaHouDun extends DefaultTargetHero {
    public XiaHouDun() {
        super(true);
    }

    @Override
    protected void initTalent() {
        final XiaHouDunSkill1 skill1 = new XiaHouDunSkill1();
        final XiaHouDunSkill2 skill2 = new XiaHouDunSkill2();

        FightService.talentProcess(id, talentInfo, tdata -> {

            final int id = tdata.id;
            switch (tdata.talentId) {
                case 605 -> skill1.talent1(id);
                case 606 -> skill1.talent2(id);
                case 613 -> skill1.talent3(id);
                case 614 -> skill2.talent1(id);
                case 615 -> addSkill(new ReduceDamageSkill());
            }
        });
        addSkill(skill1);
        addSkill(skill2);

    }
}
