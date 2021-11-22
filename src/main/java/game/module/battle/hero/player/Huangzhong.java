package game.module.battle.hero.player;

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
    }


    @Override
    protected void initTalent() {

        final HuanzhongSkill1 skill1 = new HuanzhongSkill1();
        final HuanzhongSkill2 skill2 = new HuanzhongSkill2();

        FightService.talentProcess(id, talentInfo, tdata -> {

            final int id = tdata.id;
            final int talentId = tdata.talentId;
            switch (talentId) {
                case 27 -> skill1.talent1(id);
                case 28 -> skill1.talent2(id);
                case 29 -> skill2.talent1(id);
                case 30 -> skill1.talent3(id);
                case 31 -> skill1.talent4(id);
                case 32 -> skill1.talent5(id);
            }
        });

        addSkill(skill1);
        addSkill(skill2);
    }
}