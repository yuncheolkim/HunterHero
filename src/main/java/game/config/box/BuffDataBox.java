package game.config.box;

import game.config.base.MapConfigDataBox;
import game.config.data.BuffConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class BuffDataBox extends MapConfigDataBox<BuffConfigData> {

    public BuffDataBox() {
        super("data/hero_buff.json");
    }
}
