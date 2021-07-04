package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;
import game.manager.ConfigManager;
import game.proto.data.Property;

/**
 * 修炼,历练
 *
 * @author Yunzhe.Jin
 * 2021/7/4 12:44
 */
public class PropertyConfigData extends BaseConfigData<PropertyConfigData> {
    public int gold;

    public Property property;


    @Override
    protected void fill(final DataConfigData d) {
        property = ConfigManager.makeProperty(d);
        gold = d.gold;

    }
}
