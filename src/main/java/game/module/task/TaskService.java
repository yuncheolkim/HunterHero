package game.module.task;

import game.base.G;
import game.config.DataConfigData;
import game.player.Player;
import game.proto.TaskStatusChangePush;
import game.proto.back.MsgNo;
import game.proto.data.*;
import game.utils.CalcUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/3/24 22:02
 */
public class TaskService {

    /**
     * 任务物品掉落
     *
     * @param enemyId
     * @return
     */
    public static List<Reward> dropEnemyItem(Player player, int enemyId) {
        List<Reward> list = new ArrayList<>();
        if (player.pd.getTaskBuilder().getRunTaskCount() > 0) {
            for (RunTask task : player.pd.getTaskBuilder().getRunTaskMap().values()) {
                if (!task.getComplete() && task.getTargetCount() > 0) {
                    for (TaskTarget taskTarget : task.getTargetList()) {
                        if (taskTarget.getComplete()) {
                            continue;
                        }
                        DataConfigData dataConfigData = G.C.taskMap5.get(taskTarget.getId());
                        if (dataConfigData.v3 == enemyId && CalcUtil.happened10000(dataConfigData.v4)) {
                            // 需要收集物品
                            list.add(Reward.newBuilder()
                                    .setRewardId(dataConfigData.v1)
                                    .setCount(1)
                                    .setType(RewardType.REWARD_ITEM).build());
                        }
                    }
                }
            }
        }

        return list;
    }


    /**
     * 能否接受任务
     *
     * @param player
     * @param taskId
     * @return
     */
    public static boolean canAcceptTask(Player player, int taskId) {

        return G.T.IsAcceptable(player, taskId);

    }

    /**
     * 计算任务
     *
     * @param player
     * @param sourceId 杀敌的敌人id，任务物品id等
     * @param addCount
     */
    public static void calcTaskProcess(Player player, int sourceId, int addCount, TaskTargetTypeEnum targetTypeEnum) {
        PlayerTask.Builder taskBuilder = player.pd.getTaskBuilder();

        if (taskBuilder.getRunTaskCount() > 0) {
            RunTask taskResult = null;
            TaskTarget taskTarget = null;
            int index = 0;
            for (RunTask task : taskBuilder.getRunTaskMap().values()) {
                if (task.getComplete()) {
                    continue;
                }
                for (int i = 0; i < task.getTargetCount(); i++) {
                    TaskTarget target = task.getTarget(i);
                    DataConfigData targetData = G.C.taskMap5.get(target.getId());
                    if (targetData.type == targetTypeEnum.id && targetTypeEnum.happened(sourceId, target)) {
                        index = i;
                        taskTarget = targetTypeEnum.addValue(addCount, target);
                        taskResult = task;
                        break;
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
                            .setComplete(complete)
                            .setCount(taskTarget.getValue())
                            .setTargetId(taskTarget.getId())
                            .build()
                    );
                    taskResult = null;
                    taskTarget = null;
                }
            }
        }
    }

}
