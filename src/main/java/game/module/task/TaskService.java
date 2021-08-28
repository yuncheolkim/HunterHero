package game.module.task;

import game.base.G;
import game.config.base.DataConfigData;
import game.config.data.TaskTargetConfigData;
import game.manager.ConfigManager;
import game.module.bag.BagService;
import game.player.Player;
import game.proto.TaskStatusChangePush;
import game.proto.data.*;
import game.proto.no.No;
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
                        TaskTargetConfigData dataConfigData = ConfigManager.taskTargetDataBox.findById(taskTarget.getId());
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
                    TaskTargetConfigData dataConfigData = ConfigManager.taskTargetDataBox.findById(target.getId());
                    if (dataConfigData.type == targetTypeEnum.id && targetTypeEnum.happened(sourceId, target)) {
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
                        if (taskData.completeNpcId != taskData.npcId) {
                            // 交任务的npc跟 接任务的npc不同
                            // 前一个npc完成任务
                            player.getTransport().send(No.TaskStatusChangePush, TaskStatusChangePush.newBuilder()
                                    .setNpcId(taskData.npcId)
                                    .setStatus(TaskStatusEnum.提交任务.id)
                                    .setTaskId(taskData.id)
                                    .setRunTask(builder.buildPartial())
                                    .build());
                        }


                        msgBuilder.setStatus(TaskStatusEnum.完成未提交.id);
                    } else {
                        msgBuilder.setStatus(TaskStatusEnum.进度更新.id);
                    }
                    msgBuilder.setNpcId(taskData.completeNpcId);
                    player.getTransport().send(No.TaskStatusChangePush, msgBuilder
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


    /**
     * 构建任务目标
     *
     * @param targetId
     * @return
     */
    public static TaskTarget makeTaskTarget(Player player, Integer targetId) {
        TaskTargetConfigData targetData = ConfigManager.taskTargetDataBox.findById(targetId);

        TaskTarget.Builder builder = TaskTarget.newBuilder();
        builder.setId(targetId);

        if (targetData.type == 3) {
            // 搜集物品检查背包是否有物品
            int i = BagService.itemAllCount(player, targetData.v1);
            builder.setValue(Math.min(i, targetData.v2));
            builder.setComplete(targetData.v2 == builder.getValue());
        }

        return builder.build();
    }
}
