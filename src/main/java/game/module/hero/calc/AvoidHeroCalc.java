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
 * 计算闪避
 *
 * @author Yunzhe.Jin
 * 2021/3/8 15:17
 */
public class AvoidHeroCalc extends BaseHeroCalc {
    @Override
    public void calc(PlayerHero old, PlayerHero.Builder builder) {
        HeroBaseConfigData data = ConfigManager.heroBaseProperty(old.getId(), old.getLevel());

        // base
        int value = data.getAvoid();

        // equipment
        if (old.getEquipmentCount() > 0) {
            for (Equipment equipment : old.getEquipmentMap().values()) {
                value += equipment.getProperty().getAvoid();
            }
        }
        // 历练
        HeroRealm realm = old.getPowerUpMap().get(4);
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap12.get(realm.getLevel());
            value += dataConfigData.avoid;
        }

        realm = old.getPowerUpMap().get(14);
        // 修炼
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap13.get(realm.getLevel());

            value = CalcUtil.calcRateFinal100(value, dataConfigData.avoid);
        }
        value = calcTalent(old, value, 4);

        builder.getPropertyBuilder().setAvoid(value);
    }
}
