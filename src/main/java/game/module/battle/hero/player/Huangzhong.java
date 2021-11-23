package game.module.battle.hero.player;

import game.module.battle.Hero;
import game.module.battle.skill.HuangZhongSkill1;
import game.module.battle.skill.HuangZhongSkill2;
import game.module.fight.FightService;

/**
 * 黄忠 - 1
 *
 * @author Yunzhe.Jin
 * 2021/2/1 14:32
 */
public class Huangzhong extends Hero {

    public Huangzhong() {
    }


    @Override
    protected void initTalent() {

        final HuangZhongSkill1 skill1 = new HuangZhongSkill1();
        final HuangZhongSkill2 skill2 = new HuangZhongSkill2();

        FightService.talentProcess(id, talentInfo, tdata -> {

            final int talentId = tdata.talentId;
            switch (talentId) {
                case 27 -> skill1.talent1(tdata.i1);
                case 28 -> skill1.talent2(tdata.i1);
                case 29 -> skill2.talent1(tdata.i1);
                case 30 -> skill1.talent3(tdata.i1);
                case 31 -> skill1.talent4(tdata.i1, tdata.i2);
                case 32 -> skill1.talent5(tdata.i1);
            }
        });

        addSkill(skill1);
        addSkill(skill2);
    }
}
