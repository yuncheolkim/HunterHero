package game.hunter.record;

/**
 * @author Yunzhe.Jin
 * 2021/1/18 15:27
 */
public class AttackRecord extends Record {

    public HeroRecordSimple source;

    public HeroRecordSimple target;

    public AttackRecord() {
        type = RecordTypeEnum.ATTACK;
    }
}
