package game.config.enmey;

import game.base.IWeight;
import game.proto.data.Property;

/**
 * @author Yunzhe.Jin
 * 2021/3/3 17:46
 */
public class EnemyConfigData implements IWeight {
    public int id;

    public int level;

    public int weight;

    public Property property;

    @Override
    public int weight() {
        return weight;
    }
}
