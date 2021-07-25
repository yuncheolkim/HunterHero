package game.config.box;

import game.config.base.MapConfigDataBox;
import game.config.data.DungeonInfoConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class DungeonInfoDataBox extends MapConfigDataBox<DungeonInfoConfigData> {


    public DungeonInfoDataBox() {
        super("data/dungeon_副本信息.json");
    }
}
