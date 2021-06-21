package game.module.hero.calc;

import game.base.G;
import game.config.base.DataConfigData;
import game.config.data.HeroBaseConfigData;
import game.manager.ConfigManager;
import game.proto.data.Equipment;
import game.proto.data.HeroRealm;
import game.proto.data.PlayerHero;
import game.utils.CalcUtil;

/**
 * 计算血量
 *
 * @author Yunzhe.Jin
 * 2021/3/8 15:17
 */
public class HpHeroCalc extends BaseHeroCalc {
    @Override
    public void calc(PlayerHero hero, PlayerHero.Builder builder) {
        HeroBaseConfigData data = ConfigManager.heroBaseProperty(hero.getId(), hero.getLevel());

        // base
        int value = data.getHp();

        // equipment
        if (hero.getEquipmentCount() > 0) {
            for (Equipment equipment : hero.getEquipmentMap().values()) {
                value += equipment.getProperty().getHp();
            }
        }
        // 历练
        HeroRealm realm = hero.getPowerUpMap().get(1);
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap12.get(realm.getLevel());
            value += dataConfigData.hp;
        }
        realm = hero.getPowerUpMap().get(11);

        // 修炼
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap13.get(realm.getLevel());

            value = CalcUtil.calcRateFinal100(value, dataConfigData.hp);
        }

        // Talent
        value = calcTalent(hero, value, 1);

        builder.getPropertyBuilder().setHp(value);
    }


}
