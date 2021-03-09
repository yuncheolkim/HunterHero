package game.module.hero.calc;

import game.base.G;
import game.config.DataConfigData;
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
public class CriticalDamageHeroCalc implements IHeroCalc {
    @Override
    public void calc(PlayerHero old, PlayerHero.Builder builder) {
        DataConfigData data = G.C.heroBaseProperty(old.getId(), old.getLevel());

        // base
        int criticalDamage = data.criticalDamage;

        // equipment
        if (old.getEquipmentCount() > 0) {
            for (Equipment equipment : old.getEquipmentList()) {
                criticalDamage += equipment.getProperty().getCriticalDamage();
            }
        }
        // 历练
        HeroRealm realm = old.getLiLianMap().get(7);
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap12.get(realm.getLevel());
            criticalDamage += dataConfigData.criticalDamage;
        }
        realm = old.getXiuLianMap().get(7);

        // 修炼
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap13.get(realm.getLevel());

            criticalDamage = CalcUtil.calcRate(criticalDamage, dataConfigData.criticalDamage);
        }
        builder.getPropertyBuilder().setCriticalDamage(criticalDamage);

    }
}
