package game.config.box;

import game.config.base.MapListConfigDataBox;
import game.config.data.DropItemAreaConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class DropItemAreaDataBox extends MapListConfigDataBox<DropItemAreaConfigData> {


    public DropItemAreaDataBox() {
        super("data/drop_区域掉落.json");
    }

    @Override
    protected int collectId(DropItemAreaConfigData enemyConfigData) {
        return enemyConfigData.areaId;
    }
}
