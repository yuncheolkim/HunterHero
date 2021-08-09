package game.config.box;

import game.config.base.MapConfigDataBox;
import game.config.data.HomeResourceConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class HomeResourceDataBox extends MapConfigDataBox<HomeResourceConfigData> {


    public HomeResourceDataBox() {
        super("data/home_resource.json");
    }
}
