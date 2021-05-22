package game.module.hero;

import game.config.DataConfigData;
import game.proto.data.Property;

/**
 * @author Yunzhe.Jin
 * 2021/5/21 21:18
 */
public class EquipmentService {

    public static Property makeProperty(DataConfigData data) {
        return Property.newBuilder()
                .setHp(data.hp)
                .setDamage(data.damage)
                .setDef(data.def)
                .setAvoid(data.avoid)
                .setCritical(data.critical)
                .setCriticalDamage(data.criticalDamage)
                .build();
    }
}
