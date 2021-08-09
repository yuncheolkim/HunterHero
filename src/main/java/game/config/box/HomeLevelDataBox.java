package game.config.box;

import game.config.base.MapConfigDataBox;
import game.config.data.HomeLevelConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class HomeLevelDataBox extends MapConfigDataBox<HomeLevelConfigData> {


    public HomeLevelDataBox() {
        super("data/home_level.json");
    }
}
