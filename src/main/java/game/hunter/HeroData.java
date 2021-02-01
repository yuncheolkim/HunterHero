package game.hunter;

import com.google.common.base.MoreObjects;

/**
 * @author Yunzhe.Jin
 * 2021/1/8 14:34
 */
public class HeroData {

    /**
     * 最大血量
     */
    private int maxHp;

    /**
     * 护甲
     */
    private int def;

    /**
     * 伤害
     */
    public int damage;

    /**
     * 闪避
     */
    private int avoid;

    /**
     * 暴击概率
     * x/(x+200)
     */
    private int critical;

    /**
     * 暴击伤害比例
     * x/(100)
     */
    private int criticalDamageRate;


    /**
     * 速度
     */
    private int speed;



    public HeroData merge(HeroData o) {
        maxHp += o.maxHp;
        def += o.def;
        damage += o.damage;
        avoid += o.avoid;
        critical += o.critical;
        criticalDamageRate += o.criticalDamageRate;
        speed += o.speed;
        return this;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAvoid() {
        return avoid;
    }

    public void setAvoid(int avoid) {
        this.avoid = avoid;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getCriticalDamageRate() {
        return criticalDamageRate;
    }

    public void setCriticalDamageRate(int criticalDamageRate) {
        this.criticalDamageRate = criticalDamageRate;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("maxHp", maxHp)
                .add("def", def)
                .add("damage", damage)
                .add("avoid", avoid)
                .add("critical", critical)
                .add("criticalDamageRate", criticalDamageRate)
                .add("speed", speed)
                .toString();
    }
}
