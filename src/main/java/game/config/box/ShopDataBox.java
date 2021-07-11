package game.config.box;

import game.config.base.MapConfigDataBox;
import game.config.data.ShopConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class ShopDataBox extends MapConfigDataBox<ShopConfigData> {


    public ShopDataBox() {
        super("data/shop_地图商店.json");
    }
}
