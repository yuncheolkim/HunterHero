package game.module.battle;

import com.google.common.base.MoreObjects;

/**
 * @author Yunzhe.Jin
 * 2021/1/8 14:34
 */
public class HeroData {

    /**
     * 最大血量
     */
    public int maxHp;

    /**
     * 护甲
     */
    public int def;

    /**
     * 护甲基数
     */
    public int defBase;

    /**
     * 伤害
     */
    public int damage;

    /**
     * 闪避
     */
    private int avoid;

    /**
     * 闪避基数
     */
    private int avoidBase;

    /**
     * 暴击概率
     * x/(x+criticalBase)
     */
    public int critical;

    /**
     * 当前必然暴击
     */
    public boolean mustCritical;

    /**
     * 暴击基数
     */
    public int criticalBase;

    /**
     * 暴击伤害比例
     * x/(100)
     */
    public int criticalDamageRate;

    /**
     * 对敌方护甲穿透比例
     * 万分比
     */
    private int defReduce;

    /**
     * 伤害加深比例
     * 万分比
     */
    private int harmRate;

    public HeroData merge(final HeroData o) {
        maxHp += o.maxHp;
        def += o.def;
        damage += o.damage;
        avoid += o.avoid;
        critical += o.critical;
        criticalDamageRate += o.criticalDamageRate;
        criticalBase += o.criticalBase;
        avoidBase += o.avoidBase;
        defBase += o.defBase;
        defReduce += o.defReduce;
        return this;
    }

    public HeroData copy() {
        return new HeroData().merge(this);
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(final int maxHp) {
        this.maxHp = maxHp;
    }

    public int getDef() {
        return def;
    }

    public void setDef(final int def) {
        this.def = def;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(final int damage) {
        this.damage = damage;
    }

    public int getAvoid() {
        return avoid;
    }

    public void setAvoid(final int avoid) {
        this.avoid = avoid;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(final int critical) {
        this.critical = critical;
    }


    public int getCriticalDamageRate() {
        return criticalDamageRate;
    }

    public void setCriticalDamageRate(final int criticalDamageRate) {
        this.criticalDamageRate = criticalDamageRate;
    }


    public int getDefBase() {
        return defBase;
    }

    public void setDefBase(final int defBase) {
        this.defBase = defBase;
    }

    public int getAvoidBase() {
        return avoidBase;
    }

    public void setAvoidBase(final int avoidBase) {
        this.avoidBase = avoidBase;
    }

    public int getCriticalBase() {
        return criticalBase;
    }

    public void setCriticalBase(final int criticalBase) {
        this.criticalBase = criticalBase;
    }

    public int getDefReduce() {
        return defReduce;
    }

    public void setDefReduce(final int defReduce) {
        this.defReduce = defReduce;
    }


    public int getHarmRate() {
        return harmRate;
    }

    public void setHarmRate(final int harmRate) {
        this.harmRate = harmRate;
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
                .toString();
    }
}
