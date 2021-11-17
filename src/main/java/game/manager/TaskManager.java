package game.manager;

import game.module.player.Player;
import game.module.task.accept.ITaskAccept;
import game.module.task.accept.TaskCommonAccept;
import game.module.task.accept.TaskCompleteAccept;

import java.util.ArrayList;
import java.util.List;

/**
 * 任务管理
 *
 * @author Yunzhe.Jin
 * 2021/5/12 11:25
 */
public class TaskManager {


    /**
     * 检查
     */
    private final List<ITaskAccept> acceptList = new ArrayList<>(4);

    public TaskManager() {
        acceptList.add(new TaskCommonAccept());
        acceptList.add(new TaskCompleteAccept());
    }

    public boolean IsAcceptable(Player player, int taskId) {
        return acceptList.stream().allMatch(iTaskAccept -> iTaskAccept.acceptable(player, taskId));
    }
}
