package game.config.box;

import game.config.base.MapConfigDataBox;
import game.config.data.HeroBaseConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class HeroBaseDataBox extends MapConfigDataBox<HeroBaseConfigData> {
    public HeroBaseDataBox() {
        super("data/hero_base.json");
    }
}
