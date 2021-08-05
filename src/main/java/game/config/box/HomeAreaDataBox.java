package game.config.box;

import game.config.base.MapConfigDataBox;
import game.config.data.HomeAreaConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class HomeAreaDataBox extends MapConfigDataBox<HomeAreaConfigData> {


    public HomeAreaDataBox() {
        super("data/home_area.json");
    }
}
