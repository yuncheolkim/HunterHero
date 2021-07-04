package game.module.hero.calc;

import game.config.data.HeroBaseConfigData;
import game.config.data.PropertyConfigData;
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
    public void calc(final PlayerHero old, final PlayerHero.Builder builder) {
        final HeroBaseConfigData data = ConfigManager.heroBaseProperty(old.getId(), old.getLevel());

        // base
        int value = data.getAvoid();

        // equipment
        if (old.getEquipmentCount() > 0) {
            for (final Equipment equipment : old.getEquipmentMap().values()) {
                value += equipment.getProperty().getAvoid();
            }
        }
        // 历练
        HeroRealm realm = old.getPowerUpMap().get(4);
        if (realm != null) {
            final PropertyConfigData dataConfigData = ConfigManager.lilianBox.findById(realm.getLevel());
            value += dataConfigData.property.getAvoid();
        }

        realm = old.getPowerUpMap().get(14);
        // 修炼
        if (realm != null) {
            final PropertyConfigData dataConfigData = ConfigManager.xiulianBox.findById(realm.getLevel());

            value = CalcUtil.final100(value, dataConfigData.property.getAvoid());
        }
        value = calcTalent(old, value, 4);

        builder.getPropertyBuilder().setAvoid(value);
    }
}
