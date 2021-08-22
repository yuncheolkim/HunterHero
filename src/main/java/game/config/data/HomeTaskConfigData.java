package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class HomeTaskConfigData extends BaseConfigData<HomeTaskConfigData> {

    public int day;
    public int exp;
    public int coin;

    public int itemId;
    public int count;

    @Override
    protected void fill(DataConfigData d) {

        day = d.i1;
        exp = d.i3;
        coin = d.i4;

        String[] split = d.s1.split("=");
        itemId = Integer.parseInt(split[0]);
        count = Integer.parseInt(split[1]);
    }
}
