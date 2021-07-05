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
    public Property property;

    @Override
    protected void fill(final DataConfigData d) {

        enemyId = d.i4;
        battleId = d.i1;
        pos = d.i2;
    }

    @Override
    protected void afterAllLoad0(final DataConfigData data) {
        property = ConfigManager.makePropertyFromHero(data);
        property = property.toBuilder().setSpeed(data.i3 * 100).build();

    }
}
