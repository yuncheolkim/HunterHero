package game.module.battle.buff;

import com.google.common.base.MoreObjects;
import game.config.data.BuffConfigData;
import game.manager.ConfigManager;
import game.module.battle.BattleConstant;
import game.module.battle.CoolDown;
import game.module.battle.Hero;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.BuffData;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Yunzhe.Jin
 * 2021/1/8 14:27
 */
public abstract class Buff {

    protected int id;

    protected BuffConfigData config;

    /**
     * buff触发时机
     */
    public Map<ActionPoint, Integer> effectPoint = new HashMap<>(4);

    /**
     * buff 来源
     */
    protected int sourceHeroId;

    public int[] data;

    public CoolDown cd;

    public Buff(final int id, final int sourceHeroId) {
        this.id = id;
        this.sourceHeroId = sourceHeroId;
        config = ConfigManager.buffDataBox.findById(id);
        cd = config.getCd().cold();
        if (config.data != null) {
            this.data = Arrays.copyOf(config.data, config.data.length);
        }

        for (final ActionPoint actionPoint : config.actionPointList) {
            effectPoint.put(actionPoint, 1);
        }
    }

    public void addEffectPoint(final ActionPoint actionPoint) {
        if (!effectPoint.containsKey(actionPoint)) {
            effectPoint.put(actionPoint, 1);
        }
    }

    /**
     * 是否需要重新计算属性
     *
     * @return
     */
    public boolean needReCalcProperty() {
        return effectPoint.containsKey(ActionPoint.重新计算属性);
    }

    /**
     * 减少回合数时机
     *
     * @return
     */
    public ActionPoint reducePoint() {
        return ActionPoint.回合结束后;
    }

    public boolean isInfinite() {
        return cd == BattleConstant.INFINITE;
    }

    public void reduceRound() {
        cd.reduce(1);
    }

    /**
     * 计算buff
     *
     * @param actionPoint
     * @param hero
     */
    public final void process(final ActionPoint actionPoint, final Hero hero) {

        process0(actionPoint, hero);
    }

    public boolean checkRound(final ActionPoint actionPoint, final Hero hero) {
        if (!isInfinite() && actionPoint == reducePoint()) {
            reduceRound();

            if (cd.ready()) {
                hero.removeBuff(this);
                return true;
            }
        }

        return false;
    }

    protected abstract void process0(final ActionPoint actionPoint, final Hero hero);


    /**
     * 合并buff
     *
     * @param from
     */
    public void mergeBuff(final Buff from) {
        if (from.id == id) {
            cd.cold();
            mergeData(from);
        }
    }

    protected void mergeData(final Buff from) {
        if (data != null) {
            for (int i = 0; i < data.length; i++) {
                data[i] += from.data[i];
            }
        }

    }

    public BuffData buffData() {

        final BuffData data = new BuffData();
        data.buffId = id;
        data.remainRound = cd.getRemainCd();
        return data;
    }

    public CoolDown SetCd(final int round) {
        cd = new CoolDown(round);
        return cd;
    }

    public CoolDown getCd() {
        return cd;
    }

    /**
     * 计算合并策略
     *
     * @return
     */
    public BuffMergeType calcBuffMergeType(final Buff addBuf) {
        return config.mergeType;
    }

    public String name() {
        return "N/A";
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getPriority() {
        return config.priority;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Buff buff = (Buff) o;
        return id == buff.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("actionPoint", effectPoint)
                .toString();
    }

}
