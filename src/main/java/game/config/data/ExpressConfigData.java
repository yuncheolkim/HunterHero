package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class ExpressConfigData extends BaseConfigData<ExpressConfigData> {

    public int level;
    public int time;
    public int fromNpcId;
    public int toNpcId;
    public int gold;
    public int power;

    @Override
    protected void fill(DataConfigData d) {

        level = d.level;
        time = d.i3;
        fromNpcId = d.i1;
        toNpcId = d.i2;
        gold = d.i4;
        power = d.i5;
    }
}
