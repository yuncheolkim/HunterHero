package game.hunter.record;

/**
 * @author Yunzhe.Jin
 * 2021/1/18 15:21
 */
public class HealthChangeRecord extends Record {

    public HeroRecordSimple hero;

    public int value;

    public HealthChangeRecord() {
        type = RecordTypeEnum.HEALTH_CHANGE;
    }


}
