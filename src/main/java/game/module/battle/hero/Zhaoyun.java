package game.module.battle.hero;

import game.module.battle.action.ActionPoint;
import game.module.battle.buff.hero.ZhaoyunBuff1;
import game.module.battle.hero.base.DefaultTargetHero;
import game.module.battle.skill.ZhaoyunSkill2;
import game.module.fight.FightService;

/**
 * 赵云
 *
 * @author Yunzhe.Jin
 * 2021/6/19 23:37
 */
public class Zhaoyun extends DefaultTargetHero {

    public Zhaoyun() {
        super(true);
    }

    @Override
    protected void initTalent() {

        final ZhaoyunSkill2 skill2 = new ZhaoyunSkill2();

        final ZhaoyunBuff1 addBuff = new ZhaoyunBuff1();

        FightService.talentProcess(id, talentInfo, tdata -> {

            final int i1 = tdata.i1;
            switch (tdata.talentId) {
                case 33:
                    addBuff.setRate(i1);
                    break;
                case 34:
                    addBuff.setDefRateData(i1);
                    break;
                case 35:
                    skill2.setCanAttackCount(i1);
                    break;
                case 36:
                    addBuff.setAttRateAdd(i1);
                    break;
                case 37:
                    skill2.setRate(i1);
                    break;
                case 38:
                    addBuff.setAvoidTime(i1);
                    break;
            }
        });
        addAction(ActionPoint.开场, hero -> {
            hero.addBuff(addBuff);
        });
        addSkill(skill2);
    }
}
