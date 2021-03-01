package game.module.task;

import com.google.protobuf.MessageLite;
import game.base.G;
import game.config.TaskConfigData4;
import game.exception.ModuleAssert;
import game.player.Player;
import game.proto.TaskReq;
import game.proto.data.RunTask;

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
    public static MessageLite acceptTask(Player player, TaskReq o) {

        ModuleAssert.notNull(player.getPd().getTaskBuilder().getAcceptableTaskMap().get(o.getTaskId()));

        player.getPd().getTaskBuilder().getAcceptableTaskMap().remove(o.getTaskId());

        TaskConfigData4 taskConfigData4 = G.C.taskMap4.get(o.getTaskId());
        RunTask.Builder data = RunTask.newBuilder();
        data.setTaskId(o.getTaskId());
        if (taskConfigData4.completeType == 2) {// 立即完成
            data.setStatus(3);
        } else {
            data.setStatus(2);
        }
        player.getPd().getTaskBuilder().putRunTask(o.getTaskId(), data.build());

        return null;
    }

    /**
     * 完成任务
     * @param player
     * @param o
     * @return
     */
    public static MessageLite completeTask(Player player, TaskReq o) {
        return null;
    }

}
