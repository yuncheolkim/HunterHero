package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class TempleHeroConfigData extends BaseConfigData<TempleHeroConfigData> {

    public int heroId;
    public int gold;
    public int gem;

    @Override
    protected void fill(final DataConfigData d) {
        heroId = d.i1;
        gold = d.i2;
        gem = d.i3;
    }
}
