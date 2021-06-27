package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;
import game.manager.ConfigManager;
import game.proto.data.Property;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class EnemyPropertyConfigData extends BaseConfigData<EnemyPropertyConfigData> {

    public Property property;
    public int enemyId;
    public int level;

    @Override
    protected void fill(DataConfigData d) {
        super.fill(d);
        enemyId = d.enemyId;
        level = d.level;
    }

    @Override
    protected void afterAllLoad0(DataConfigData data) {
        property = ConfigManager.makePropertyFromHero(data);
    }
}
