package game.module.battle.hero;

import game.module.battle.Hero;
import game.module.battle.skill.HuanzhongSkill1;
import game.module.battle.skill.HuanzhongSkill2;
import game.module.fight.FightService;

/**
 * 黄忠
 *
 * @author Yunzhe.Jin
 * 2021/2/1 14:32
 */
public class Huangzhong extends Hero {

    public Huangzhong() {
        id = 1002;
    }


    @Override
    protected void initTalent() {

        final HuanzhongSkill1 skill1 = new HuanzhongSkill1();
        final HuanzhongSkill2 skill2 = new HuanzhongSkill2();

        FightService.talentProcess(id, talentInfo, tdata -> {

            switch (tdata.talentId) {
                case 27:
                    skill1.addCount(tdata.i1);
                    break;
                case 28:
                    skill1.setRate(tdata.i1);
                    break;
                case 29:
                    skill2.setRate(tdata.i1);
                    break;
                case 30:
                    skill1.addCount(tdata.i1);
                    break;
                case 31:
                    skill1.setHappenRate(tdata.i1);
                    skill1.setHappenCount(tdata.i2);
                    break;
                case 32:
                    skill1.addRate(skill1.getRate());
                    break;
            }
        });

        addSkill(skill1);
        addSkill(skill2);
    }
}
