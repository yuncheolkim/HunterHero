package game.module.task;

import game.base.G;
import game.config.base.DataConfigData;
import game.manager.ConfigManager;
import game.player.Player;
import game.proto.TaskStatusChangePush;
import game.proto.back.MsgNo;
import game.proto.data.*;
import game.utils.CalcUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
                        if (dataConfigData.v4 > 0 && dataConfigData.v3 == enemyId && CalcUtil.happened10000(dataConfigData.v4)) {
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
                    builder.setTarget(index, taskTarget);
                    boolean complete = true;
                    for (TaskTarget.Builder target : builder.getTargetBuilderList()) {
                        if (!target.getComplete()) {
                            complete = false;
                            break;
                        }
                    }
                    builder.setComplete(complete);

                    RunTask runTask = builder.build();
                    taskBuilder.putRunTask(runTask.getTaskId(), runTask);

                    // push
                    TaskStatusChangePush.Builder msgBuilder = TaskStatusChangePush.newBuilder()
                            .setTaskId(runTask.getTaskId())
                            .setCount(taskTarget.getValue())
                            .setTargetId(taskTarget.getId())
                            .setRunTask(runTask);

                    DataConfigData taskData = G.C.getTask(taskResult.getTaskId());
                    if (complete) {
                        msgBuilder.setStatus(TaskStatusEnum.完成未提交.id);
                    } else {
                        msgBuilder.setStatus(TaskStatusEnum.进度更新.id);
                    }
                    msgBuilder.setNpcId(taskData.npcId);
                    player.getTransport().send(MsgNo.TaskStatusChangePushNo_VALUE, msgBuilder
                            .build()
                    );
                    taskResult = null;
                    taskTarget = null;
                }
            }
        }
    }

    /**
     * 升级查找新任务
     *
     * @param player
     * @return
     */
    public static List<Integer> findLevelTask(Player player) {

        Collection<DataConfigData> dataConfigData = ConfigManager.levelTaskMap.get(player.pd.getLevel());

        if (dataConfigData.isEmpty()) {
            return Collections.emptyList();
        }

        return dataConfigData.stream().map(data -> data.id).collect(Collectors.toList());
    }

}
