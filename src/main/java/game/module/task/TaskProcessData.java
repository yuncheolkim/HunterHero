package game.module.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import game.base.Copy;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 11:49
 */
public class TaskProcessData implements Copy {

    @JsonProperty
    public int id;

    /**
     * 1	送信
     * 2	打怪
     * 3	搜集物品
     */
    @JsonProperty
    public int taskType;

    /**
     * 需求量
     */
    @JsonProperty
    public int need;

    /**
     * 当前量
     */
    @JsonProperty
    public int current;

    public TaskProcessData copy() {
        TaskProcessData data = new TaskProcessData();
        data.id = id;
        data.taskType = taskType;
        data.need = need;
        data.current = current;
        return data;
    }
}
