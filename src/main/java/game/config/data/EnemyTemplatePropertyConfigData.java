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
    public EnemyTemplatePropertyConfigData convert(DataConfigData data) {
        EnemyTemplatePropertyConfigData convert = super.convert(data);
        convert.property = ConfigManager.makeProperty(data);
        return convert;
    }

}
