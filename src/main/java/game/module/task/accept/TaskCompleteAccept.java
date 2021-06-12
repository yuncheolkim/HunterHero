package game.module.task.accept;

import game.base.G;
import game.config.base.DataConfigData;
import game.player.Player;

import java.util.Map;

/**
 * 判断是否已完成
 *
 * @author Yunzhe.Jin
 * 2021/5/12 11:33
 */
public class TaskCompleteAccept implements ITaskAccept {
    @Override
    public boolean acceptable(Player player, int taskId) {
        // 是否已完成
        Map<Integer, Boolean> completeTaskMap = player.D.getCompleteTaskMap();
        if (completeTaskMap.containsKey(taskId)) {
            return false;
        }

        DataConfigData data = G.C.getTask(taskId);
        if (data.list1 != null) {
            for (Integer beforeId : data.list1) {
                if (!completeTaskMap.containsKey(beforeId)) {
                    return false;
                }
            }
        }
        return true;
    }
}
