package game.config.box;

import game.config.base.MapConfigDataBox;
import game.config.data.DungeonConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class DungeonDataBox extends MapConfigDataBox<DungeonConfigData> {


    public DungeonDataBox() {
        super("data/dungeon_Battle.json");
    }
}
