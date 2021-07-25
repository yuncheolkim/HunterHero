package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class DungeonConfigData extends BaseConfigData<DungeonConfigData> {

    public int battleId;

    @Override
    protected void fill(DataConfigData d) {

        battleId = d.i1;
    }
}
