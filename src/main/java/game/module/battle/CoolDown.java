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
    private int cd;

    /**
     * 当前冷却数
     */
    private int curCd;

    /**
     * 冷却
     */
    public void cold() {
        curCd = cd;
    }

    /**
     * 减少cd回合数
     *
     * @param round 减少的回合数
     */
    public void reduce(int round) {
        curCd -= round;
        if (curCd < 0) {
            curCd = 0;
        }
    }

    /**
     * 重置
     */
    public void reset() {
        curCd = 0;
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

    public void setCd(int cd) {
        this.cd = cd;
    }

    public int getCurCd() {
        return curCd;
    }

    public void setCurCd(int curCd) {
        this.curCd = curCd;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("cd", cd)
                .add("curCd", curCd)
                .toString();
    }
}
