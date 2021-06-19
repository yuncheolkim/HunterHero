package game.config.box;

import game.config.base.MapListConfigDataBox;
import game.config.data.DropItemEnemyConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class DropItemEnemyDataBox extends MapListConfigDataBox<DropItemEnemyConfigData> {


    public DropItemEnemyDataBox() {
        super("data/drop_敌人掉落.json");
    }


    @Override
    protected int collectId(DropItemEnemyConfigData dropItemEnemyConfigData) {
        return dropItemEnemyConfigData.enemyId;
    }
}
