package game.module.hero.calc;

import game.proto.data.PlayerHero;

/**
 * 计算速度
 *
 * @author Yunzhe.Jin
 * 2021/3/8 15:17
 */
public class SpeedHeroCalc implements IHeroCalc {
    @Override
    public void calc(PlayerHero old, PlayerHero.Builder builder) {
//        DataConfigData data = G.C.heroBaseProperty(old.getId(), old.getLevel());
//
//        // base
//        int speed = data.speed;
//
//        // equipment
//        if (old.getEquipmentCount() > 0) {
//            for (Equipment equipment : old.getEquipmentMap().values()) {
//                speed += equipment.getProperty().getSpeed();
//            }
//        }
//        // 历练
//        HeroRealm realm = old.getPowerUpMap().get(5);
//        if (realm != null) {
//            DataConfigData dataConfigData = G.C.dataMap12.get(realm.getLevel());
//            speed += dataConfigData.speed;
//        }
//        realm = old.getPowerUpMap().get(5);
//
//        // 修炼
//        if (realm != null) {
//            DataConfigData dataConfigData = G.C.dataMap13.get(realm.getLevel());
//
//            speed = CalcUtil.calcRate(speed, dataConfigData.speed);
//        }
//        builder.getPropertyBuilder().setSpeed(speed);

    }
}
