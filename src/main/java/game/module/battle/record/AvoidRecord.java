package game.module.battle.record;

/**
 * @author Yunzhe.Jin
 * 2021/1/18 15:21
 */
public class AvoidRecord extends Record {
    public HeroRecordSimple hero;

    public AvoidRecord() {
        type = RecordTypeEnum.AVOID;
    }
}
