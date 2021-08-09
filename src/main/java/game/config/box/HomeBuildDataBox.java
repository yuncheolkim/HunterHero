package game.config.box;

import game.config.base.MapConfigDataBox;
import game.config.data.HomeBuildConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class HomeBuildDataBox extends MapConfigDataBox<HomeBuildConfigData> {


    public HomeBuildDataBox() {
        super("data/home_build.json");
    }
}
