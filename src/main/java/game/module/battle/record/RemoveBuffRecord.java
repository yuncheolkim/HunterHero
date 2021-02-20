package game.module.battle.record;

import game.module.battle.action.ActionPoint;

import static game.module.battle.record.RecordTypeEnum.BUFF_REMOVE;

/**
 * @author Yunzhe.Jin
 * 2021/1/18 15:22
 */
public class RemoveBuffRecord extends Record {
    public ActionPoint actionPoint;

    public HeroRecordSimple hero;

    public int id;

    public RemoveBuffRecord() {
        type = BUFF_REMOVE;
    }
}
