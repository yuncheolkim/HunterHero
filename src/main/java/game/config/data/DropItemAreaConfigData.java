package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/19 20:41
 */
public class DropItemAreaConfigData extends BaseConfigData<DropItemAreaConfigData> {

    public int areaId;
    public int itemId;
    public int count;
    public int rate;


    @Override
    protected void fill(DataConfigData d) {
        areaId = d.areaId;
        itemId = d.itemId;
        count = d.count;
        rate = d.rate;
    }
}
