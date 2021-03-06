package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;
import game.manager.ConfigManager;
import game.proto.data.Property;

/**
 * @author Yunzhe.Jin
 * 2021/5/31 15:05
 */
public class EnemyTemplatePropertyConfigData extends BaseConfigData<EnemyTemplatePropertyConfigData> {

    public Property property;

    @Override
    protected void fill(DataConfigData data) {
        property = ConfigManager.makeProperty(data);
    }
}
