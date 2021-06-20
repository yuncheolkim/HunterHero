package game.module.hero.calc;

import game.config.data.HeroBaseConfigData;
import game.manager.ConfigManager;
import game.proto.data.Equipment;
import game.proto.data.PlayerHero;

/**
 * 计算防御基数
 *
 * @author Yunzhe.Jin
 * 2021/3/8 15:17
 */
public class DefBaseHeroCalc extends BaseHeroCalc {
    @Override
    public void calc(PlayerHero old, PlayerHero.Builder builder) {
        HeroBaseConfigData data = ConfigManager.heroBaseProperty(old.getId(), old.getLevel());

        // base
        int defBase = data.getDefBase();

        // equipment
        if (old.getEquipmentCount() > 0) {
            for (Equipment equipment : old.getEquipmentMap().values()) {
                defBase += equipment.getProperty().getDefBase();
            }
        }
        
        builder.getPropertyBuilder().setDefBase(defBase);
    }
}
