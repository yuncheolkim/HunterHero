package game.module.hero.calc;

import game.config.data.HeroBaseConfigData;
import game.config.data.PropertyConfigData;
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
    public void calc(final PlayerHero old, final PlayerHero.Builder builder) {
        final HeroBaseConfigData data = ConfigManager.heroBaseProperty(old.getId(), old.getLevel());

        // base
        int value = data.getDef();

        // equipment
        if (old.getEquipmentCount() > 0) {
            for (final Equipment equipment : old.getEquipmentMap().values()) {
                value += equipment.getProperty().getDef();
            }
        }
        // 历练
        HeroRealm realm = old.getPowerUpMap().get(3);
        if (realm != null) {
            final PropertyConfigData dataConfigData = ConfigManager.lilianBox.findById(realm.getLevel());
            value += dataConfigData.property.getDef();
        }
        realm = old.getPowerUpMap().get(13);

        // 修炼
        if (realm != null) {
            final PropertyConfigData dataConfigData = ConfigManager.xiulianBox.findById(realm.getLevel());

            value = CalcUtil.final100(value, dataConfigData.property.getDef());
        }
        value = calcTalent(old, value, 3);

        builder.getPropertyBuilder().setDef(value);
    }
}
