package game.config.box;

import game.config.base.MapConfigDataBox;
import game.config.data.HomeItemConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class HomeItemDataBox extends MapConfigDataBox<HomeItemConfigData> {


    public HomeItemDataBox() {
        super("data/home_item.json");
    }
}
