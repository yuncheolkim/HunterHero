package game.config.box;

import game.config.base.RandomConfigDataBox;
import game.config.data.EnemyCountConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class EnemyCountDataBox extends RandomConfigDataBox<EnemyCountConfigData> {


    public EnemyCountDataBox() {
        super("data/data_16-区域敌人数量.json");
    }


}
