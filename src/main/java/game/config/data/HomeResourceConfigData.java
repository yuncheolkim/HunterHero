package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class HomeResourceConfigData extends BaseConfigData<HomeResourceConfigData> {
    public boolean inBag;

    public int coin;
    public int exp;

    @Override
    protected void fill(DataConfigData d) {

        inBag = d.i2 == 1;
        coin = d.i3;
        exp = d.i4;
    }
}
