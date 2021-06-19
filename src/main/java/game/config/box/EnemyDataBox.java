package game.config.box;

import game.config.base.MapListConfigDataBox;
import game.config.data.EnemyConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class EnemyDataBox extends MapListConfigDataBox<EnemyConfigData> {


    public EnemyDataBox() {
        super("data/data_15-enemy.json");
    }

    @Override
    protected int collectId(EnemyConfigData enemyConfigData) {
        return enemyConfigData.enemyAreaId;
    }
}
