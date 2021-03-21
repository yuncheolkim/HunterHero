package game.module.hero.calc;

import game.base.G;
import game.config.DataConfigData;
import game.proto.data.Equipment;
import game.proto.data.PlayerHero;

/**
 * 计算暴击基数
 *
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
            for (Equipment equipment : old.getEquipmentMap().values()) {
                criticalBase += equipment.getProperty().getCriticalBase();
            }
        }
        builder.getPropertyBuilder().setCriticalBase(criticalBase);

    }
}
