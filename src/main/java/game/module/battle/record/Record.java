package game.module.battle.record;

import game.module.battle.CoolDown;
import game.module.battle.action.ActionPoint;
import game.proto.data.DamageType;
import game.proto.data.RecordType;

import java.util.List;

/**
 * 战斗记录
 * @author Yunzhe.Jin
 * 2021/1/8 15:26
 */
public class Record {
    public RecordType type;

    public ActionPoint actionPoint;

    public HeroRecordSimple hero;

    public List<HeroRecordSimple> target;

    public int id;

    public CoolDown cd;

    public BuffData buffData;

    public DamageType damageType;

    public int value;

    public Record(RecordType type) {
        this.type = type;
    }

}
