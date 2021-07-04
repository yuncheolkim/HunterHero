package game.module.hero.calc;

import game.config.data.HeroBaseConfigData;
import game.config.data.PropertyConfigData;
import game.manager.ConfigManager;
import game.proto.data.Equipment;
import game.proto.data.HeroRealm;
import game.proto.data.PlayerHero;
import game.utils.CalcUtil;

/**
 * 计算伤害
 *
 * @author Yunzhe.Jin
 * 2021/3/8 15:17
 */
public class DamageHeroCalc extends BaseHeroCalc {
    @Override
    public void calc(final PlayerHero old, final PlayerHero.Builder builder) {
        final HeroBaseConfigData data = ConfigManager.heroBaseProperty(old.getId(), old.getLevel());

        // base
        int damage = data.getDamage();

        // equipment
        if (old.getEquipmentCount() > 0) {
            for (final Equipment equipment : old.getEquipmentMap().values()) {
                damage += equipment.getProperty().getDamage();
            }
        }
        // 历练
        HeroRealm realm = old.getPowerUpMap().get(2);
        if (realm != null) {
            final PropertyConfigData dataConfigData = ConfigManager.lilianBox.findById(realm.getLevel());
            damage += dataConfigData.property.getDamage();
        }
        realm = old.getPowerUpMap().get(12);

        // 修炼
        if (realm != null) {
            final PropertyConfigData dataConfigData = ConfigManager.xiulianBox.findById(realm.getLevel());

            damage = CalcUtil.final100(damage, dataConfigData.property.getDamage());
        }

        // 天赋
        damage = calcTalent(old, damage, 2);

        builder.getPropertyBuilder().setDamage(damage);

    }
}
