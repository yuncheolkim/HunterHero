package game.module.hero.calc;

import game.base.G;
import game.config.DataConfigData;
import game.proto.data.Equipment;
import game.proto.data.HeroRealm;
import game.proto.data.PlayerHero;
import game.utils.CalcUtil;

/**
 * 计算闪避
 * @author Yunzhe.Jin
 * 2021/3/8 15:17
 */
public class AvoidHeroCalc implements IHeroCalc {
    @Override
    public void calc(PlayerHero old, PlayerHero.Builder builder) {
        DataConfigData data = G.C.heroBaseProperty(old.getId(), old.getLevel());

        // base
        int avoid = data.avoid;

        // equipment
        if (old.getEquipmentCount() > 0) {
            for (Equipment equipment : old.getEquipmentList()) {
                avoid += equipment.getProperty().getAvoid();
            }
        }
        // 历练
        HeroRealm realm = old.getLiLianMap().get(4);
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap12.get(realm.getLevel());
            avoid += dataConfigData.avoid;
        }
        realm = old.getXiuLianMap().get(4);

        // 修炼
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap13.get(realm.getLevel());

            avoid = CalcUtil.calcRate(avoid, dataConfigData.avoid);
        }
        builder.getPropertyBuilder().setAvoid(avoid);

    }
}
