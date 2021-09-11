package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/9/11 21:08
 */
public class LadderSingleConfigData extends BaseConfigData<LadderSingleConfigData> {

    public int k;

    @Override
    protected void fill(DataConfigData d) {
        k = d.i2;
    }
}
