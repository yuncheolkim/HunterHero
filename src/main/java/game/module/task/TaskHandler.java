package game.module.task;

import com.google.protobuf.MessageLite;
import game.base.G;
import game.config.TaskConfigData4;
import game.exception.ModuleAssert;
import game.module.player.PlayerData;
import game.player.Player;
import game.proto.TaskReq;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 11:26
 */
public class TaskHandler {

    /**
     * 接受任务
     * @param player
     * @param o
     * @return
     */
    public static MessageLite addTask(Player player, TaskReq o) {

        ModuleAssert.isTrue(player.getPlayerData().acceptTask.contains(o.getTaskId()));

        player.getPlayerData().acceptTask.remove(o.getTaskId());

        TaskConfigData4 taskConfigData4 = G.C.taskMap4.get(o.getTaskId());
        TaskData data = new TaskData();
        data.taskId = o.getTaskId();
        if (taskConfigData4.completeType == 2) {// 立即完成
            data.status = 3;
        } else {
            data.status = 2;
        }
        player.getPlayerData().runTask.put(data.taskId, data);

        return null;
    }

    /**
     * 完成任务
     * @param player
     * @param o
     * @return
     */
    public static MessageLite completeTask(Player player, TaskReq o) {
        PlayerData playerData = player.getPlayerData();
        TaskData data = playerData.runTask.remove(o.getTaskId());
        if (data != null) {
            playerData.completeTask.add(data.taskId);
        }
        return null;
    }

}
