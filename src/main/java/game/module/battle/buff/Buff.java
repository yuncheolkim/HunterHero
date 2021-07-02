package game.module.battle.buff;

import com.google.common.base.MoreObjects;
import game.config.data.BuffConfigData;
import game.manager.ConfigManager;
import game.module.battle.BattleConstant;
import game.module.battle.CoolDown;
import game.module.battle.Hero;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.BuffData;

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
    public Map<ActionPoint, Integer> effectPoint = new HashMap<>();

    /**
     * buff 来源
     */
    protected Hero source;

    /**
     * 相同buff合并规则
     */
    protected BuffMergeType buffMergeType = BuffMergeType.REPLACE;

    public int[] data;

    public CoolDown cd;

    public Buff(int id) {
        this.id = id;
        config = ConfigManager.buffDataBox.findById(id);
        cd = config.getCd().cold();
    }

    public void init() {
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

    public void checkRound(final ActionPoint actionPoint, final Hero hero) {
        if (!isInfinite() && actionPoint == reducePoint()) {
            reduceRound();

            if (cd.ready()) {
                hero.removeBuff(this);
            }
        }
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

    protected void mergeData(Buff from) {

    }

    public BuffData buffData() {

        final BuffData data = new BuffData();
        data.buffId = id;
        data.remainRound = cd.getRemainCd();
        return data;
    }

    /**
     * 计算合并策略
     *
     * @return
     */
    public BuffMergeType calcBuffMergeType(final Buff addBuf) {
        return buffMergeType;
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

    public Hero getSource() {
        return source;
    }

    public void setSource(final Hero source) {
        this.source = source;
    }

    public BuffMergeType getBuffMergeType() {
        return buffMergeType;
    }

    public void setBuffMergeType(final BuffMergeType buffMergeType) {
        this.buffMergeType = buffMergeType;
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
