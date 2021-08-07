package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;
import game.proto.data.HomeType;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class HomeItemConfigData extends BaseConfigData<HomeItemConfigData> {

    public HomeType type;

    public int w;

    public int h;

    @Override
    protected void fill(DataConfigData d) {
        type = HomeType.forNumber(d.type);
        w = d.i1;
        h = d.i2;
    }

}
