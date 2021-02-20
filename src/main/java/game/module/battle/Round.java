package game.module.battle;

import com.fasterxml.jackson.annotation.JsonProperty;
import game.module.battle.record.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/1/8 16:57
 */
public class Round {
    /**
     * 回合数
     */
    @JsonProperty("count")
    private int roundCount;

    @JsonProperty("records")
    private List<Record> recordList = new ArrayList<>();


    public void addRecord(Record action) {
        recordList.add(action);
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }


}
