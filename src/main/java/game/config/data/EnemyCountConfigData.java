package game.config.data;

import game.base.IWeight;
import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/3/3 20:58
 */
public class EnemyCountConfigData extends BaseConfigData<EnemyCountConfigData> implements IWeight {
    public int count;
    public int weight;
    public int enemyAreaId;


    @Override
    protected void fill(DataConfigData d) {
        count = d.count;
        weight = d.weight;
        enemyAreaId = d.enemyAreaId;
    }

    @Override
    public int weight() {
        return weight;
    }
}
