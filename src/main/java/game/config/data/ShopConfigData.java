package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/6/7 16:38
 */
public class ShopConfigData extends BaseConfigData<ShopConfigData> {
    public List<Integer> items = new ArrayList<>();

    @Override
    protected void fill(final DataConfigData d) {
        items.addAll(d.list1);
    }
}
