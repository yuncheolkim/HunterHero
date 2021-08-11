package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class HomeLevelConfigData extends BaseConfigData<HomeLevelConfigData> {

    public int exp;

    @Override
    protected void fill(DataConfigData d) {

        exp = d.i1;
    }
}
