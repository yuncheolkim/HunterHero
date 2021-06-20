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
 * 计算暴击
 *
 * @author Yunzhe.Jin
 * 2021/3/8 15:17
 */
public class CriticalHeroCalc extends BaseHeroCalc {
    @Override
    public void calc(PlayerHero old, PlayerHero.Builder builder) {
        HeroBaseConfigData data = ConfigManager.heroBaseProperty(old.getId(), old.getLevel());

        // base
        int value = data.getCritical();

        // equipment
        if (old.getEquipmentCount() > 0) {
            for (Equipment equipment : old.getEquipmentMap().values()) {
                value += equipment.getProperty().getCritical();
            }
        }
        // 历练
        HeroRealm realm = old.getPowerUpMap().get(5);
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap12.get(realm.getLevel());
            value += dataConfigData.critical;
        }
        realm = old.getPowerUpMap().get(15);

        // 修炼
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap13.get(realm.getLevel());

            value = CalcUtil.calcRateFinal(value, dataConfigData.critical);
        }
        // 天赋
        value = calcTalent(old, value, 5);
        builder.getPropertyBuilder().setCritical(value);

    }
}
