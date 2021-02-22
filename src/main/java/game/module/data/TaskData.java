package game.module.data;

import game.base.Copy;

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


    public TaskData copy() {
        TaskData data = new TaskData();
        data.taskId = taskId;
        data.status = status;
        return data;
    }
}
