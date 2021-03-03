package game.config.enmey;

import game.base.IWeight;

/**
 * @author Yunzhe.Jin
 * 2021/3/3 20:58
 */
public class EnemyCountConfigData implements IWeight {
    public int count;
    public int weight;

    @Override
    public int weight() {
        return weight;
    }
}
