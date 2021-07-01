package game.module.battle.buff;

import com.google.common.base.MoreObjects;
import game.config.data.BuffConfigData;
import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.BuffData;

import java.util.*;

import static game.module.battle.BattleConstant.BUFF_INFINITE;

/**
 * @author Yunzhe.Jin
 * 2021/1/8 14:27
 */
public abstract class Buff {

    protected int id;

    /**
     * 优先级
     */
    protected int priority;

    /**
     * 持续回合
     * BUFF_INFINITE 永久有效
     */
    protected int round = BUFF_INFINITE;

    /**
     * 剩余回合
     */
    protected int remainRound;

    /**
     * bufftype
     */
    protected BuffType buffType = BuffType.BUFF;

    /**
     * buff 效果
     */
    protected List<BuffEffect> effects = new ArrayList<>();

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

    /**
     * buff名
     */
    protected String name;

    /**
     * 是否可以移除
     */
    protected boolean move;


    public void init() {
        BuffConfigData data = ConfigManager.buffDataBox.findById(id);
        move = data.move;
        buffType = data.type;
        name = data.name;
    }

    public void initRound(final int round) {
        this.round = round;
        this.remainRound = round;

    }

    /**
     * 减少回合数时机
     *
     * @return
     */
    public ActionPoint reducePoint() {
        return ActionPoint.回合结束后;
    }

    public boolean isActive() {
        if (round == BUFF_INFINITE) {
            return true;
        }

        return remainRound > 0;

    }

    public int reduceRound() {
        if (round == BUFF_INFINITE) {
            return BUFF_INFINITE;
        }
        return --remainRound;
    }

    /**
     * 计算buff
     *
     * @param actionPoint
     * @param hero
     */
    public void process(final ActionPoint actionPoint, final Hero hero) {
        for (final BuffEffect effect : effects) {
            if (!effect.doEffect(hero, this)) {
                break;
            }
        }
    }


    /**
     * 返回buff相关数据
     *
     * @return
     */
    public IBuffVal buffVal() {
        return new DefaultBuffData();
    }

    /**
     * 合并buff
     *
     * @param from
     */
    public void mergeBuff(final Buff from) {
        if (from.id == id) {
            remainRound = round;
            buffVal().merge(from.buffVal());
        }
    }

    public BuffData buffData() {

        final BuffData data = new BuffData();
        data.buffId = id;
        data.round = round;
        data.remainRound = remainRound;
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
        return priority;
    }

    public void setPriority(final int priority) {
        this.priority = priority;
    }

    public int getRound() {
        return round;
    }

    public void setRound(final int round) {
        this.round = round;
    }

    public Hero getSource() {
        return source;
    }

    public void setSource(final Hero source) {
        this.source = source;
    }

    public int getRemainRound() {
        return remainRound;
    }

    public void setRemainRound(final int remainRound) {
        this.remainRound = remainRound;
    }

    public BuffMergeType getBuffMergeType() {
        return buffMergeType;
    }

    public void setBuffMergeType(final BuffMergeType buffMergeType) {
        this.buffMergeType = buffMergeType;
    }

    public boolean isMove() {
        return move;
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
                .add("buffType", buffType)
                .toString();
    }
}
