package game.module.hero.calc;

import game.base.G;
import game.config.DataConfigData;
import game.proto.data.Equipment;
import game.proto.data.PlayerHero;

/**
 * 计算血量
 *
 * @author Yunzhe.Jin
 * 2021/3/8 15:17
 */
public class AvoidBaseHeroCalc implements IHeroCalc {
    @Override
    public void calc(PlayerHero old, PlayerHero.Builder builder) {
        DataConfigData data = G.C.heroBaseProperty(old.getId(), old.getLevel());

        // base
        int avoidBase = data.avoidBase;

        // equipment
        if (old.getEquipmentCount() > 0) {
            for (Equipment equipment : old.getEquipmentList()) {
                avoidBase += equipment.getProperty().getAvoidBase();
            }
        }
        builder.getPropertyBuilder().setAvoidBase(avoidBase);

    }
}
