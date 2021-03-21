package game.module.hero.calc;

import game.base.G;
import game.config.DataConfigData;
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
public class DefHeroCalc implements IHeroCalc {
    @Override
    public void calc(PlayerHero old, PlayerHero.Builder builder) {
        DataConfigData data = G.C.heroBaseProperty(old.getId(), old.getLevel());

        // base
        int def = data.def;

        // equipment
        if (old.getEquipmentCount() > 0) {
            for (Equipment equipment : old.getEquipmentMap().values()) {
                def += equipment.getProperty().getDef();
            }
        }
        // 历练
        HeroRealm realm = old.getLiLianMap().get(3);
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap12.get(realm.getLevel());
            def += dataConfigData.def;
        }
        realm = old.getXiuLianMap().get(3);

        // 修炼
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap13.get(realm.getLevel());

            def = CalcUtil.calcRate(def, dataConfigData.def);
        }
        builder.getPropertyBuilder().setDef(def);
    }
}
