package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;
import game.game.ItemQualityEnum;
import game.game.ItemTypeEnum;
import game.game.ResourceEnum;
import game.manager.ConfigManager;
import game.proto.data.Property;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class ItemConfigData extends BaseConfigData<ItemConfigData> {

    public int level;
    public ItemTypeEnum type;
    public ItemQualityEnum quality;
    public int stack;
    public ResourceEnum resourceType;
    public int value;
    public int sell;

    public Property property;
    public int type2;

    @Override
    protected void fill(DataConfigData d) {
        level = d.level;
        type = ItemTypeEnum.find(d.type1);
        quality = ItemQualityEnum.find(d.quality);
        stack = d.stack;
        resourceType = (ResourceEnum) ResourceEnum.display(d.resourceId);
        value = d.value;
        sell = d.sell;
        type2 = d.type2;
    }


    @Override
    protected void afterAllLoad0(DataConfigData data) {
        if (type == ItemTypeEnum.EQUIPMENT) {
            property = ConfigManager.makePropertyFromHero(data);
        }
    }
}
