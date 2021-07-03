package game.module.battle.damage;

import game.module.battle.Hero;
import game.proto.data.DamageType;
import game.utils.CalcUtil;

/**
 * 造成伤害的信息
 *
 * @author Yunzhe.Jin
 * 2021/1/11 14:56
 */
public class DamageInfo {
    public DamageType type;

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

    public int allSourceDamage() {
        return sourceDamage + sourceCriticalDamage;
    }

    public void reduceDamage(final float rate) {
        sourceDamage = CalcUtil.calcRateSub(sourceDamage, rate);
        sourceCriticalDamage = CalcUtil.calcRateSub(sourceCriticalDamage, rate);
    }

    /**
     * 减少伤害
     *
     * @param v
     */
    public void reduceDamageValue(final int v) {
        final int s = sourceCriticalDamage;
        sourceCriticalDamage -= Math.max(s, s - v);

        if (sourceCriticalDamage == 0) {
            sourceDamage -= Math.min(v - s, sourceDamage);
        }
    }

    /**
     * 调整伤害，不能超过max
     *
     * @param maxDamageable
     */
    public void adjustDamageHp(final int maxDamageable) {

        if (allSourceDamage() > maxDamageable) {
            final int temp = (allSourceDamage() - maxDamageable) / 2;

            sourceDamage -= temp;
            sourceCriticalDamage -= temp;


            if (sourceCriticalDamage < 0) {
                // 益出部分加入普通攻击减伤里面
                sourceDamage += sourceCriticalDamage;
                sourceCriticalDamage = 0;
            }

            if (sourceDamage < 0) {
                sourceDamage = 0;
            }
        }

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
