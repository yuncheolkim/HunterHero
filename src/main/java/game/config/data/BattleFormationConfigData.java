package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;
import game.manager.ConfigManager;
import game.proto.data.Property;

/**
 * @author Yunzhe.Jin
 * 2021/6/15 20:26
 */
public class BattleFormationConfigData extends BaseConfigData<BattleFormationConfigData> {

    public int enemyId;
    public int battleId;
    public int pos;
    public int order;
    public int level;
    public Property property;

    @Override
    protected void fill(DataConfigData d) {

        enemyId = d.i4;
        battleId = d.i1;
        pos = d.i2;
        order = d.i3;
        level = d.level;
        property = ConfigManager.makePropertyByTemplate(d);
    }
}
