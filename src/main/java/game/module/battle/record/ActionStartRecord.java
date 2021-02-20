package game.module.battle.record;

public class ActionStartRecord extends Record {

    public HeroRecordSimple hero;

    public ActionStartRecord() {
        type = RecordTypeEnum.ACTION;
    }
}
