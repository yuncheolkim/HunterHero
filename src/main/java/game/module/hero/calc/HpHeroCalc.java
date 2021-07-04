package game.module.hero.calc;

import game.config.data.HeroBaseConfigData;
import game.config.data.PropertyConfigData;
import game.manager.ConfigManager;
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
public class HpHeroCalc extends BaseHeroCalc {
    @Override
    public void calc(final PlayerHero hero, final PlayerHero.Builder builder) {
        final HeroBaseConfigData data = ConfigManager.heroBaseProperty(hero.getId(), hero.getLevel());

        // base
        int value = data.getHp();

        // equipment
        if (hero.getEquipmentCount() > 0) {
            for (final Equipment equipment : hero.getEquipmentMap().values()) {
                value += equipment.getProperty().getHp();
            }
        }
        // 历练
        HeroRealm realm = hero.getPowerUpMap().get(1);
        if (realm != null) {
            final PropertyConfigData dataConfigData = ConfigManager.lilianBox.findById(realm.getLevel());
            value += dataConfigData.property.getHp();
        }
        realm = hero.getPowerUpMap().get(11);

        // 修炼
        if (realm != null) {
            final PropertyConfigData dataConfigData = ConfigManager.xiulianBox.findById(realm.getLevel());
            value = CalcUtil.final100(value, dataConfigData.property.getHp());
        }

        // Talent
        value = calcTalent(hero, value, 1);

        builder.getPropertyBuilder().setHp(value);
    }


}
