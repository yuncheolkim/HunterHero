package game.config.data;

import game.base.IWeight;
import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/13 22:22
 */
public class FishWeightConfigData extends BaseConfigData<FishWeightConfigData> implements IWeight {
    private int w;

    public int fishId;
    public int fishAreaId;


    @Override
    protected void fill(DataConfigData d) {
        w = d.i3;
        fishAreaId = d.i1;
        fishId = d.i2;
    }

    @Override
    public int weight() {
        return w;
    }
}
