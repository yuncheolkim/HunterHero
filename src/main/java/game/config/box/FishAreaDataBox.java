package game.config.box;

import game.config.base.MapConfigDataBox;
import game.config.data.FishAreaConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 20:30
 */
public class FishAreaDataBox extends MapConfigDataBox<FishAreaConfigData> {
    public FishAreaDataBox() {
        super("data/fish_区域.json");
    }
}
