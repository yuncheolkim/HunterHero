package game.module.hero.calc;

import game.base.G;
import game.config.DataConfigData;
import game.proto.data.Equipment;
import game.proto.data.HeroRealm;
import game.proto.data.PlayerHero;
import game.utils.CalcUtil;

/**
 * 计算血量
 * @author Yunzhe.Jin
 * 2021/3/8 15:17
 */
public class CriticalBaseHeroCalc implements IHeroCalc {
    @Override
    public void calc(PlayerHero old, PlayerHero.Builder builder) {
        DataConfigData data = G.C.heroBaseProperty(old.getId(), old.getLevel());

        // base
        int criticalBase = data.criticalBase;

        // equipment
        if (old.getEquipmentCount() > 0) {
            for (Equipment equipment : old.getEquipmentList()) {
                criticalBase += equipment.getProperty().getCriticalBase();
            }
        }
        // 历练
        HeroRealm realm = old.getLiLianMap().get(1);
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap12.get(realm.getLevel());
            criticalBase += dataConfigData.criticalBase;
        }
        realm = old.getXiuLianMap().get(1);

        // 修炼
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap13.get(realm.getLevel());

            criticalBase = CalcUtil.calcRate(criticalBase, dataConfigData.criticalBase);
        }
        builder.getPropertyBuilder().setCriticalBase(criticalBase);

    }
}
