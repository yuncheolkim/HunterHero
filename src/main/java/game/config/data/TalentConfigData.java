package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/20 0:25
 */
public class TalentConfigData extends BaseConfigData<TalentConfigData> {

    public int talentId;
    public int i1;
    public int i2;
    public int i3;

    @Override
    protected void fill(DataConfigData d) {
        talentId = d.talentId;
        i1 = d.i1;
        i2 = d.i2;
        i3 = d.i3;
    }
}
