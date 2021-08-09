package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class HomeResourceConfigData extends BaseConfigData<HomeResourceConfigData> {

    public String content;

    @Override
    protected void fill(DataConfigData d) {

        content = d.s1;
    }
}
