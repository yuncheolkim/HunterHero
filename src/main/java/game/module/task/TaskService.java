package game.module.task;

import game.base.G;
import game.config.DataConfigData;
import game.player.Player;
import game.proto.TaskStatusChangePush;
import game.proto.back.MsgNo;
import game.proto.data.PlayerTask;
import game.proto.data.RunTask;
import game.proto.data.TaskTarget;

/**
 * @author Yunzhe.Jin
 * 2021/3/24 22:02
 */
public class TaskService {


    /**
     * 计算任务
     *
     * @param player
     * @param targetId
     * @param addCount
     */
    public static void calcTaskProcess(Player player, int targetId, int addCount, TaskTargetTypeEnum targetTypeEnum) {
        PlayerTask.Builder taskBuilder = player.pd.getTaskBuilder();

        if (taskBuilder.getRunTaskCount() > 0) {
            RunTask taskResult = null;
            TaskTarget taskTarget = null;
            int index = 0;
            for (RunTask task : taskBuilder.getRunTaskMap().values()) {
                for (int i = 0; i < task.getTargetCount(); i++) {
                    TaskTarget target = task.getTarget(i);
                    DataConfigData targetData = G.C.taskMap5.get(target.getId());
                    if (targetData.type == targetTypeEnum.id
                            && targetData.v2 > target.getValue()
                            && targetData.v1 == targetId
                    ) {
                        index = i;
                        int count = Math.min(target.getValue() + addCount, targetData.v2);

                        taskTarget = target.toBuilder()
                                .setValue(count)
                                .setComplete(count == targetData.v2)
                                .build();
                        taskResult = task;
                        break;
                    }
                }
            }

            //
            if (taskResult != null) {
                RunTask.Builder builder = taskResult.toBuilder();
                boolean complete = true;
                for (TaskTarget.Builder target : builder.getTargetBuilderList()) {
                    if (!target.getComplete()) {
                        complete = false;
                        break;
                    }
                }
                builder.setComplete(complete);

                RunTask build = builder.setTarget(index, taskTarget).build();
                taskBuilder.putRunTask(build.getTaskId(), build);

                // push
                player.getTransport().send(MsgNo.TaskStatusChangePushNo_VALUE, TaskStatusChangePush.newBuilder()
                        .setTaskId(build.getTaskId())
                        .setStatus(complete ? 3 : 2)
                        .setCount(taskTarget.getValue())
                        .setTargetId(taskTarget.getId())
                        .build()
                );

            }
        }
    }

}
