package game.config.box;

import game.config.base.MapListConfigDataBox;
import game.config.data.FishWeightConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/13 22:29
 */
public class FishDataBox extends MapListConfigDataBox<FishWeightConfigData> {
    public FishDataBox() {
        super("data/fish_捕鱼概率.json");
    }

    @Override
    protected int collectId(FishWeightConfigData fishWeightConfigData) {
        return fishWeightConfigData.fishAreaId;
    }
}
