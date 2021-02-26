package game.module.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import game.base.Copy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 11:49
 */
public class TaskData implements Copy {

    @JsonProperty
    public int taskId;

    /**
     * 2:进行中，3:已完成未提交, 4:已完成
     */
    @JsonProperty
    public int status;

    /**
     * 完成目标
     */
    @JsonProperty
    public List<TaskProcessData> processDataList = new ArrayList<>();

    public TaskData copy() {
        TaskData data = new TaskData();
        data.taskId = taskId;
        data.status = status;
        data.processDataList = processDataList.stream().map(TaskProcessData::copy).collect(Collectors.toList());
        return data;
    }
}
