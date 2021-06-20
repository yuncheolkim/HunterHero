package game.module.battle.buff.data;

import game.module.battle.buff.IBuffVal;

/**
 * @author Yunzhe.Jin
 * 2021/1/8 17:49
 */
public class OneAttackBuffData extends BuffVal {

    private int current = 10;
    private int stack = 50;

    @Override
    public int i1() {
        return current;
    }

    /**
     * 最大叠加数
     *
     * @return
     */
    @Override
    public int i2() {
        return stack;
    }

    @Override
    public void merge(IBuffVal from) {
        this.current += from.i1();
        if (this.current > i2()) {
            this.current = i2();
        }
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getStack() {
        return stack;
    }

    public void setStack(int stack) {
        this.stack = stack;
    }
}

