package game.config.data;

import game.base.IWeight;
import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;
import game.manager.ConfigManager;
import game.proto.data.Property;

/**
 * @author Yunzhe.Jin
 * 2021/3/3 17:46
 */
public class EnemyConfigData extends BaseConfigData<EnemyConfigData> implements IWeight {

    public int weight;
    public int enemyAreaId;
    public int enemyId;

    public Property property;

    @Override
    protected void fill(DataConfigData d) {
        this.enemyId = d.enemyId;
        this.level = d.level;
        this.weight = d.weight;
        this.enemyAreaId = d.enemyAreaId;
    }


    @Override
    protected void afterAllLoad0(DataConfigData data) {
        property = ConfigManager.makePropertyFromHero(data);
    }

    @Override
    public int weight() {
        return weight;
    }
}
