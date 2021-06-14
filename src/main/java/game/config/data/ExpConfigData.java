package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/14 13:32
 */
public class ExpConfigData extends BaseConfigData<ExpConfigData> {
    public int needExp;
    public int monsterExp;
    public int taskExp;
    public int minGold;
    public int maxGold;

    @Override
    protected void fill(DataConfigData d) {
        needExp = d.i1;
        monsterExp = d.i2;
        taskExp = d.i3;
        minGold = d.i4;
        maxGold = d.i5;
    }
}
