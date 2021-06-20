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
 * 计算防御
 *
 * @author Yunzhe.Jin
 * 2021/3/8 15:17
 */
public class DefHeroCalc extends BaseHeroCalc {
    @Override
    public void calc(PlayerHero old, PlayerHero.Builder builder) {
        HeroBaseConfigData data = ConfigManager.heroBaseProperty(old.getId(), old.getLevel());

        // base
        int value = data.getDef();

        // equipment
        if (old.getEquipmentCount() > 0) {
            for (Equipment equipment : old.getEquipmentMap().values()) {
                value += equipment.getProperty().getDef();
            }
        }
        // 历练
        HeroRealm realm = old.getPowerUpMap().get(3);
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap12.get(realm.getLevel());
            value += dataConfigData.def;
        }
        realm = old.getPowerUpMap().get(13);

        // 修炼
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap13.get(realm.getLevel());

            value = CalcUtil.calcRateFinal(value, dataConfigData.def);
        }
        value = calcTalent(old, value, 3);

        builder.getPropertyBuilder().setDef(value);
    }
}
