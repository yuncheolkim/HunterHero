package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class EndlessRateConfigData extends BaseConfigData<EndlessRateConfigData> {

    public float rate;

    @Override
    protected void fill(DataConfigData d) {
        rate = d.f1;
    }
}
