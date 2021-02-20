package game.module.battle.record;

/**
 * 战斗记录
 *
 * @author Yunzhe.Jin
 * 2021/1/8 15:26
 */
public class Record {
    protected RecordTypeEnum type;

    public RecordTypeEnum getType() {
        return type;
    }

    public void setType(RecordTypeEnum type) {
        this.type = type;
    }
}
