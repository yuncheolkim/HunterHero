package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;
import game.module.battle.buff.BuffType;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class BuffConfigData extends BaseConfigData<BuffConfigData> {

    public boolean move;
    public BuffType type;

    @Override
    protected void fill(DataConfigData d) {

        move = d.i1 == 1;
        type = d.type == 1 ? BuffType.BUFF : BuffType.DE_BUFF;
    }
}
