package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;
import game.manager.ConfigManager;
import game.proto.data.Property;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class HeroBaseConfigData extends BaseConfigData<HeroBaseConfigData> {

    public Property property;


    @Override
    protected void fill(DataConfigData d) {

        property = ConfigManager.makeProperty(d);
    }

    public int getHp() {
        return property.getHp();
    }

    public int getDamage() {
        return property.getDamage();
    }

    public int getDef() {
        return property.getDef();
    }

    public int getAvoid() {
        return property.getAvoid();
    }

    public int getCritical() {
        return property.getCritical();
    }

    public int getCriticalDamage() {
        return property.getCriticalDamage();
    }

    public int getAvoidBase() {
        return property.getAvoidBase();
    }

    public int getCriticalBase() {
        return property.getCriticalBase();
    }

    public int getDefBase() {
        return property.getDefBase();
    }
}
