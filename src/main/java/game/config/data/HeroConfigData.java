package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class HeroConfigData extends BaseConfigData<HeroConfigData> {

    public String title;
    public List<Integer> talent;

    @Override
    protected void fill(DataConfigData d) {

        title = d.title;
        if (d.list2 != null) {
            talent = new ArrayList<>(d.list2);
        }
    }
}
