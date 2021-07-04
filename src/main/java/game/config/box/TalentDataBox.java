package game.config.box;

import game.config.base.MapConfigDataBox;
import game.config.data.TalentConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class TalentDataBox extends MapConfigDataBox<TalentConfigData> {


    public TalentDataBox() {
        super("data/hero_英雄天赋.json");
    }
}
