package game.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/6/7 16:38
 */
public class ShopConfigData extends BaseConfigData<ShopConfigData> {
    public List<Integer> items = new ArrayList<>();

    @Override
    public ShopConfigData convert(final DataConfigData data) {
        final ShopConfigData convert = super.convert(data);
        convert.items.addAll(data.list1);
        return convert;
    }
}
