package game.module.battle.hero;

import game.config.data.HeroConfigData;
import game.config.data.TalentConfigData;
import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.buff.data.OneAttackBuffData;
import game.module.battle.find.BackTargetStrategy;
import game.module.battle.find.FrontTargetStrategy;
import game.module.battle.find.OneAttackBuffFindTargetStrategy;
import game.module.battle.skill.GuanyuSkill1;
import game.module.battle.skill.GuanyuSkill2;
import game.utils.CalcUtil;

import java.util.List;

/**
 * 关羽
 *
 * @author Yunzhe.Jin
 * 2021/1/11 10:33
 */
public class Guanyu extends Hero {


    public Guanyu() {
        id = 1001;
        targetStrategies.add(new OneAttackBuffFindTargetStrategy());
        targetStrategies.add(new FrontTargetStrategy());
        targetStrategies.add(new BackTargetStrategy());
    }

    @Override
    public void init() {
        super.init();

        processTalent();
    }

    private void processTalent() {
        HeroConfigData heroConfig = ConfigManager.heroDataBox.findById(id);

        GuanyuSkill1 skill1 = new GuanyuSkill1();
        GuanyuSkill2 skill2 = new GuanyuSkill2();
        List<Integer> talentList = CalcUtil.getIntList(talentInfo);
        OneAttackBuffData buffData = new OneAttackBuffData();

        for (int i = 0; i < talentList.size(); i++) {
            final int talentRowIndex = talentList.get(i);
            if (talentRowIndex == 9) {
                continue;
            }
            int index = i * 3 + talentRowIndex - 1;
            int talentId = heroConfig.talent.get(index);
            TalentConfigData tdata = ConfigManager.talentDataBox.findById(talentId);
            if (tdata.talentId <= 20) {
                continue;
            }

            switch (tdata.talentId) {
                case 21:
                    buffData.setStack(tdata.i1);
                    break;
                case 22:
                    buffData.setCurrent(tdata.i1);
                    break;
                case 23:
                    skill2.setRow(true);
                    break;
                case 24:
                    skill1.setAddDamageRate(tdata.i1);
                    break;
                case 25:
                    skill1.setAddCritical(tdata.i1);
                    break;
                case 26:
                    skill2.setRate(tdata.i1);
                    break;
            }
        }

        skill1.setData(buffData);

        addSkill(skill1);
        addSkill(skill2);
    }

}
