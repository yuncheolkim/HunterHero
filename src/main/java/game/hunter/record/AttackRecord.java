package game.hunter.record;

import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/1/18 15:27
 */
public class AttackRecord extends Record {

    public HeroRecordSimple source;

    public List<HeroRecordSimple> target;

    public AttackRecord() {
        type = RecordTypeEnum.ATTACK;
    }
}
