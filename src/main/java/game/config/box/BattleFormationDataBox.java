package game.config.box;

import game.config.base.MapListConfigDataBox;
import game.config.data.BattleFormationConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/13 22:29
 */
public class BattleFormationDataBox extends MapListConfigDataBox<BattleFormationConfigData> {

    public BattleFormationDataBox() {
        super("data/battle_formation.json");
    }

    @Override
    protected int collectId(BattleFormationConfigData fishWeightConfigData) {
        return fishWeightConfigData.battleId;
    }
}
