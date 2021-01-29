package game.hunter.damage;

import game.hunter.Hero;

/**
 * 造成伤害的信息
 *
 * @author Yunzhe.Jin
 * 2021/1/11 14:56
 */
public class DamageInfo {
    private DamageSourceType type;

    private int sourceId;

    /**
     * 造成的伤害
     */
    private int sourceDamage;

    /**
     * 造成的伤害
     */
    private int attackedDamage;

    /**
     * 是否闪避
     */
    private boolean avoid;

    /**
     * 目标
     */
    private Hero target;

    /**
     * 最初伤害来源
     */
    private Hero origin;

    /**
     * 直接伤害来源
     */
    private Hero current;


    public int getAttackedDamage() {
        return attackedDamage;
    }

    public void setAttackedDamage(int attackedDamage) {
        this.attackedDamage = attackedDamage;
    }

    public Hero getTarget() {
        return target;
    }

    public void setTarget(Hero target) {
        this.target = target;
    }

    public Hero getOrigin() {
        return origin;
    }

    public void setOrigin(Hero origin) {
        this.origin = origin;
    }

    public Hero getCurrent() {
        return current;
    }

    public void setCurrent(Hero current) {
        this.current = current;
    }

    public boolean isAvoid() {
        return avoid;
    }

    public void setAvoid(boolean avoid) {
        this.avoid = avoid;
    }

    public int getSourceDamage() {
        return sourceDamage;
    }

    public void setSourceDamage(int sourceDamage) {
        this.sourceDamage = sourceDamage;
    }

    public DamageSourceType getType() {
        return type;
    }

    public void setType(DamageSourceType type) {
        this.type = type;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    @Override
    public String toString() {
        return "DamageInfo{" +
                "value=" + attackedDamage +
                ", avoid=" + avoid +
                ", target=" + target +
                ", origin=" + origin +
                ", current=" + current +
                '}';
    }
}
