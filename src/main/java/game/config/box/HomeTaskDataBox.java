package game.config.box;

import game.config.base.MapListConfigDataBox;
import game.config.data.HomeTaskConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class HomeTaskDataBox extends MapListConfigDataBox<HomeTaskConfigData> {


    public HomeTaskDataBox() {
        super("data/home_task.json");
    }

    @Override
    protected int collectId(HomeTaskConfigData homeTaskConfigData) {
        return homeTaskConfigData.day;
    }
}
