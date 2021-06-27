package game.config.box;

import game.config.base.MapConfigDataBox;
import game.config.data.EnemyPropertyConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class EnemyPropertyDataBox extends MapConfigDataBox<EnemyPropertyConfigData> {


    public EnemyPropertyDataBox() {
        super("data/enemy_野怪属性.json");
    }

}
