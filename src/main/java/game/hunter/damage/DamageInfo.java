package game.hunter.damage;

import game.hunter.Hero;

/**
 * 造成伤害的信息
 *
 * @author Yunzhe.Jin
 * 2021/1/11 14:56
 */
public class DamageInfo {
    public DamageSourceType type;

    public int sourceId;

    /**
     * 造成的普通伤害
     */
    public int sourceDamage;

    /**
     * 造成的暴击伤害
     */
    public int sourceCriticalDamage;

    /**
     * 造成的伤害
     */
    public int attackedDamage;

    /**
     * 是否闪避
     */
    public boolean avoid;

    /**
     * 目标
     */
    public Hero target;

    /**
     * 最初伤害来源
     */
    public Hero origin;

    /**
     * 直接伤害来源
     */
    public Hero source;

    public int allSourceDamage(){
        return sourceDamage + sourceCriticalDamage;
    }

    @Override
    public String toString() {
        return "DamageInfo{" +
                "value=" + attackedDamage +
                ", avoid=" + avoid +
                ", target=" + target +
                ", origin=" + origin +
                '}';
    }
}
