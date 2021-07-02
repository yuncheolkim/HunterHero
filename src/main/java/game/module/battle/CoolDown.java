package game.module.battle;

import com.google.common.base.MoreObjects;

/**
 * @author Yunzhe.Jin
 * 2021/1/8 14:53
 */
public class CoolDown {

    /**
     * 冷却回数
     */
    private final int cd;

    /**
     * 当前冷却数
     */
    private int curCd;

    public CoolDown() {
        this(0);
    }

    public CoolDown(int cd) {
        this.cd = cd;
    }

    /**
     * 使用冷却
     */
    public CoolDown cold() {
        curCd = cd;
        return this;
    }

    /**
     * 减少cd回合数
     *
     * @param round 减少的回合数
     */
    public CoolDown reduce(int round) {
        curCd = Math.max(0, curCd - round);
        return this;
    }

    /**
     * 重置
     */
    public CoolDown reset() {
        curCd = 0;
        return this;
    }

    /**
     * 是否可用
     *
     * @return true 是
     */
    public boolean ready() {
        return curCd == 0;
    }


    public int getCd() {
        return cd;
    }

    public int getRemainCd() {
        return curCd;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("cd", cd)
                .add("curCd", curCd)
                .toString();
    }
}
