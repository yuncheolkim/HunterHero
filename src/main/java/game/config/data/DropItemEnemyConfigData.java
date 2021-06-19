package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/19 20:41
 */
public class DropItemEnemyConfigData extends BaseConfigData<DropItemEnemyConfigData> {

    public int itemId;
    public int enemyId;
    public int count;
    public int rate;


    @Override
    protected void fill(DataConfigData d) {
        itemId = d.itemId;
        enemyId = d.enemyId;
        count = d.count;
        rate = d.rate;
    }
}
