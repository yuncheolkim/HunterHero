package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;
import game.module.battle.BattleConstant;
import game.module.battle.CoolDown;
import game.module.battle.buff.BuffType;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class BuffConfigData extends BaseConfigData<BuffConfigData> {

    /**
     * 是否可移除
     */
    public boolean move;

    public BuffType type;

    public int priority;

    public int round;

    public int[] data;

    @Override
    protected void fill(DataConfigData d) {

        move = d.i1 == 1;
        type = d.type == 1 ? BuffType.BUFF : BuffType.DE_BUFF;
        round = d.round;
        priority = d.priority;

        if (d.list1 != null) {
            data = new int[d.list1.size()];

            for (int i = 0; i < data.length; i++) {
                data[i] = d.list1.get(i);
            }
        }
    }

    public CoolDown getCd() {
        if (round == 0) {
            return BattleConstant.INFINITE;
        }

        return new CoolDown(round);
    }
}
