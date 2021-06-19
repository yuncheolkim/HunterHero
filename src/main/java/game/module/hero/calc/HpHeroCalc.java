package game.module.hero.calc;

import game.base.G;
import game.config.base.DataConfigData;
import game.config.data.HeroBaseConfigData;
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
public class HpHeroCalc implements IHeroCalc {
    @Override
    public void calc(PlayerHero old, PlayerHero.Builder builder) {
        HeroBaseConfigData data = G.C.heroBaseProperty(old.getId(), old.getLevel());

        // base
        int hp = data.getHp();

        // equipment
        if (old.getEquipmentCount() > 0) {
            for (Equipment equipment : old.getEquipmentMap().values()) {
                hp += equipment.getProperty().getHp();
            }
        }
        // 历练
        HeroRealm realm = old.getPowerUpMap().get(1);
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap12.get(realm.getLevel());
            hp += dataConfigData.hp;
        }
        realm = old.getPowerUpMap().get(11);

        // 修炼
        if (realm != null) {
            DataConfigData dataConfigData = G.C.dataMap13.get(realm.getLevel());

            hp = CalcUtil.calcRateFinal(hp, dataConfigData.hp);
        }

        builder.getPropertyBuilder().setHp(hp);

    }
}
