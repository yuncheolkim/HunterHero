package game.module.hero.calc;

import game.base.G;
import game.config.base.DataConfigData;
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
public class DamageHeroCalc implements IHeroCalc {
    @Override
    public void calc(PlayerHero old, PlayerHero.Builder builder) {
        DataConfigData data = G.C.heroBaseProperty(old.getId(), old.getLevel());

        // base
        int damage = data.damage;

        // equipment
        if (old.getEquipmentCount() > 0) {
            for (Equipment equipment : old.getEquipmentMap().values()) {
                damage += equipment.getProperty().getDamage();
            }
        }
        // 历练
        HeroRealm realm = old.getPowerUpMap().get(2);
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap12.get(realm.getLevel());
            damage += dataConfigData.damage;
        }
        realm = old.getPowerUpMap().get(12);

        // 修炼
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap13.get(realm.getLevel());

            damage = CalcUtil.calcRateFinal(damage, dataConfigData.damage);
        }
        builder.getPropertyBuilder().setDamage(damage);

    }
}
