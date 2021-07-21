package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class BattleInfoConfigData extends BaseConfigData<BattleInfoConfigData> {

    public boolean manual;

    @Override
    protected void fill(DataConfigData d) {

        manual = d.i1 == 1;

        name = null;
    }
}
