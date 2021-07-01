package game.module.hero.calc;

import game.config.data.HeroConfigData;
import game.config.data.TalentConfigData;
import game.manager.ConfigManager;
import game.proto.data.PlayerHero;
import game.utils.CalcUtil;

import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/6/20 13:31
 */
public abstract class BaseHeroCalc implements IHeroCalc {


    /**
     * 天赋计算
     *
     * @param hero
     * @param value
     * @param type
     * @return
     */
    protected int calcTalent(final PlayerHero hero, int value, final int type) {
        final HeroConfigData heroConfig = ConfigManager.heroDataBox.findById(hero.getId());
        final List<Integer> talentList = CalcUtil.getIntList(hero.getTalent());
        for (int i = 0; i < talentList.size(); i++) {
            final Integer talentRowIndex = talentList.get(i);
            if (talentRowIndex == 9) {
                continue;
            }
            final int index = i * 3 + talentRowIndex - 1;
            final Integer talentId = heroConfig.talent.get(index);
            final TalentConfigData tdata = ConfigManager.talentDataBox.findById(talentId);

            if (tdata.talentId == type) {
                value = CalcUtil.final100(value, tdata.i1);
            }
        }
        return value;
    }
}
