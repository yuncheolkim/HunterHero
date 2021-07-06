package game.module.battle.record;

import game.module.battle.CoolDown;
import game.module.battle.action.ActionPoint;
import game.proto.data.DamageType;
import game.proto.data.DisplayPoint;
import game.proto.data.RecordType;

import java.util.List;

/**
 * 战斗记录
 *
 * @author Yunzhe.Jin
 * 2021/1/8 15:26
 */
public class Record {
    public RecordType type;

    public ActionPoint actionPoint;

    public DisplayPoint dp = DisplayPoint.DP_DEF_1;

    public DamageType damageType;

    public int heroId;

    public int pos;

    /**
     * 目标位置
     */
    public List<Integer> targetList;

    public int id;

    public CoolDown cd;

    public BuffData buffData;

    public int value;

    public Record(final RecordType type) {
        this.type = type;
    }

}
