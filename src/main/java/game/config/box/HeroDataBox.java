package game.config.box;

import game.config.base.MapConfigDataBox;
import game.config.data.HeroConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class HeroDataBox extends MapConfigDataBox<HeroConfigData> {


    public HeroDataBox() {
        super("data/data_1-hero.json");
    }
}
