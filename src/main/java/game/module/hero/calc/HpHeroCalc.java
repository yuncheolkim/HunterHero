package game.module.hero.calc;

import game.base.G;
import game.config.base.DataConfigData;
import game.config.data.HeroBaseConfigData;
import game.config.data.HeroConfigData;
import game.config.data.TalentConfigData;
import game.manager.ConfigManager;
import game.proto.data.Equipment;
import game.proto.data.HeroRealm;
import game.proto.data.PlayerHero;
import game.utils.CalcUtil;

import java.util.List;

/**
 * 计算血量
 *
 * @author Yunzhe.Jin
 * 2021/3/8 15:17
 */
public class HpHeroCalc implements IHeroCalc {
    @Override
    public void calc(PlayerHero hero, PlayerHero.Builder builder) {
        HeroBaseConfigData data = ConfigManager.heroBaseProperty(hero.getId(), hero.getLevel());

        // base
        int hp = data.getHp();

        // equipment
        if (hero.getEquipmentCount() > 0) {
            for (Equipment equipment : hero.getEquipmentMap().values()) {
                hp += equipment.getProperty().getHp();
            }
        }
        // 历练
        HeroRealm realm = hero.getPowerUpMap().get(1);
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap12.get(realm.getLevel());
            hp += dataConfigData.hp;
        }
        realm = hero.getPowerUpMap().get(11);

        // 修炼
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap13.get(realm.getLevel());

            hp = CalcUtil.calcRateFinal(hp, dataConfigData.hp);
        }

        HeroConfigData heroConfig = ConfigManager.heroDataBox.findById(hero.getId());

        // 天赋
        List<Integer> talentList = CalcUtil.getIntList(hero.getTalent());
        for (int i = 0; i < talentList.size(); i++) {
            int index = i * 3 + talentList.get(i) - 1;
            Integer talentId = heroConfig.talent.get(index);

            TalentConfigData tdata = ConfigManager.talentDataBox.findById(talentId);

            if (tdata.talentId == 1) {
                hp = CalcUtil.calcRateFinal(hp, tdata.i1);
                continue;
            }


        }


        builder.getPropertyBuilder().setHp(hp);

    }
}
