package game.hunter.record;

/**
 * @author Yunzhe.Jin
 * 2021/1/18 15:22
 */
public class AddBuffRecord extends Record {

    public BuffData buffData;

    public HeroRecordSimple hero;

    public AddBuffRecord() {
        type = RecordTypeEnum.BUFF_ADD;
    }

}
