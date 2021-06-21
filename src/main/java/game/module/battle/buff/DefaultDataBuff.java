package game.module.battle.buff;

import game.module.battle.record.BuffData;

/**
 * @author Yunzhe.Jin
 * 2021/2/3 20:02
 */
public class DefaultDataBuff extends Buff {
    protected DefaultBuffData data = new DefaultBuffData();

    /**
     * 返回buff相关数据
     *
     * @return
     */
    public IBuffVal buffVal() {
        return data;
    }

    public BuffData buffData() {

        BuffData d = super.buffData();
        d.i1 = data.i1();
        d.i2 = data.i2();
        d.i3 = data.i3();

        d.f1 = data.f1();
        d.f2 = data.f2();
        return d;
    }
}
