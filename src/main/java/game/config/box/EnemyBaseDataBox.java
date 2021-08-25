package game.config.box;

import game.config.base.MapConfigDataBox;
import game.config.data.HeroBaseConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class EnemyBaseDataBox extends MapConfigDataBox<HeroBaseConfigData> {
    public EnemyBaseDataBox() {
        super("data/enemy_基本属性.json");
    }
}
