package game.hunter.buff;

import com.google.common.base.MoreObjects;
import game.hunter.Hero;
import game.hunter.action.ActionPoint;
import game.hunter.record.BuffData;

import java.util.ArrayList;
import java.util.List;

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
     */
    protected int round;

    /**
     * 剩余回合
     */
    protected int remainRound;

    /**
     * buff 效果
     */
    protected List<BuffEffect> effects = new ArrayList<>();

    /**
     * buff触发时机
     */
    protected ActionPoint actionPoint;

    /**
     * bufftype
     */
    protected BuffType buffType;

    /**
     * buff 来源
     */
    protected Hero source;

    /**
     * 相同buff合并规则
     */
    protected BuffMergeType buffMergeType;


    public void initRound(int round) {
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

    public int reduceRound() {
        return --remainRound;
    }

    /**
     * 计算buff
     *
     * @param hero
     */
    public void process(Hero hero) {
        for (BuffEffect effect : effects) {
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
    public abstract IBuffVal buffVal();

    /**
     * 合并buff
     *
     * @param from
     */
    public void mergeBuff(Buff from) {
        if (from.id == id) {
            remainRound = round;
            buffVal().merge(from.buffVal());
        }
    }

    public BuffData buffData() {

        BuffData data = new BuffData();
        data.buffId = id;
        data.round = round;
        data.remainRound = remainRound;
        return data;
    }


    public boolean canMerge(Buff addBuff) {
        return true;
    }

    /**
     * 计算合并策略
     *
     * @return
     */
    public BuffMergeType calcBuffMergeType(Buff addBuf) {
        return buffMergeType;
    }

    public String name() {
        return "N/A";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public ActionPoint getActionPoint() {
        return actionPoint;
    }

    public void setActionPoint(ActionPoint actionPoint) {
        this.actionPoint = actionPoint;
    }

    public Hero getSource() {
        return source;
    }

    public void setSource(Hero source) {
        this.source = source;
    }

    public int getRemainRound() {
        return remainRound;
    }

    public void setRemainRound(int remainRound) {
        this.remainRound = remainRound;
    }

    public BuffMergeType getBuffMergeType() {
        return buffMergeType;
    }

    public void setBuffMergeType(BuffMergeType buffMergeType) {
        this.buffMergeType = buffMergeType;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("actionPoint", actionPoint)
                .add("buffType", buffType)
                .toString();
    }
}
