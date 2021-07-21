package game.config.box;

import game.config.base.MapConfigDataBox;
import game.config.data.BattleInfoConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class BattleInfoDataBox extends MapConfigDataBox<BattleInfoConfigData> {


    public BattleInfoDataBox() {
        super("data/battle_战斗说明.json");
    }
}
