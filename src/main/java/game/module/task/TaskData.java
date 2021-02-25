package game.module.task;

import game.base.Copy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 11:49
 */
public class TaskData implements Copy {

    public int taskId;

    /**
     * 2:进行中，3:已完成未提交, 4:已完成
     */
    public int status;

    /**
     * 完成目标
     */
    public List<TaskProcessData> processDataList = new ArrayList<>();

    public TaskData copy() {
        TaskData data = new TaskData();
        data.taskId = taskId;
        data.status = status;
        data.processDataList = processDataList.stream().map(TaskProcessData::copy).collect(Collectors.toList());
        return data;
    }
}
