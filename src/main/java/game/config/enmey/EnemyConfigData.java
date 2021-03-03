package game.config.enmey;

import game.base.IWeight;

/**
 * @author Yunzhe.Jin
 * 2021/3/3 17:46
 */
public class EnemyConfigData implements IWeight {
    public int id;
    public int level;
    public int weight;
    public int hp;
    public int damage;
    public int def;
    public int defBase;
    public int avoid;
    public int avoidBase;
    public int critical;
    public int criticalBase;
    public int criticalDamage;
    public int speed;


    @Override
    public int weight() {
        return weight;
    }
}
