package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;
import game.module.battle.BattleConstant;
import game.module.battle.CoolDown;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.BuffMergeType;
import game.module.battle.buff.BuffType;

import java.util.ArrayList;
import java.util.List;

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

    public BuffMergeType mergeType;

    public int priority;

    public int round;

    public int[] data;

    public List<ActionPoint> actionPointList = new ArrayList<>(1);

    @Override
    protected void fill(final DataConfigData d) {

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

        if (d.sList != null) {
            for (final String action : d.sList) {
                final ActionPoint actionPoint = ActionPoint.valueOf(action);
                actionPointList.add(actionPoint);
            }
        }

        mergeType = d.i2 == 1 ? BuffMergeType.MERGE : BuffMergeType.REPLACE;
    }

    public CoolDown getCd() {
        if (round == 0) {
            return BattleConstant.INFINITE;
        }

        return new CoolDown(round);
    }
}
