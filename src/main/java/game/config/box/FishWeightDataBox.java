package game.config.box;

import game.config.base.WeightMapConfigDataBox;
import game.config.data.FishWeightConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/13 22:29
 */
public class FishWeightDataBox extends WeightMapConfigDataBox<FishWeightConfigData> {
    public FishWeightDataBox() {
        super("data/fish_捕鱼概率.json");
    }

    @Override
    protected int collectId(FishWeightConfigData fishWeightConfigData) {
        return fishWeightConfigData.fishAreaId;
    }
}
