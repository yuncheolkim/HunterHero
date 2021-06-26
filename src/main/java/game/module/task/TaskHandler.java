package game.module.task;

import game.base.G;
import game.base.constants.GameConstants;
import game.config.base.DataConfigData;
import game.config.data.ExpConfigData;
import game.config.data.ItemConfigData;
import game.config.data.TaskTargetConfigData;
import game.exception.ErrorEnum;
import game.exception.ModuleAssert;
import game.game.ItemTypeEnum;
import game.game.ResourceEnum;
import game.game.ResourceSourceEnum;
import game.manager.ConfigManager;
import game.manager.EventManager;
import game.module.bag.BagService;
import game.module.event.handler.TaskCompleteEvent;
import game.player.Player;
import game.proto.*;
import game.proto.back.MsgNo;
import game.proto.data.*;
import game.utils.RewardUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 任务系统
 *
 * @author Yunzhe.Jin
 * 2021/2/22 11:26
 */
public class TaskHandler {

    /**
     * 接受任务
     *
     * @param player
     * @param o
     * @return
     */
    public static void acceptTask(final Player player, final TaskReq o) {

        ModuleAssert.isTrue(TaskService.canAcceptTask(player, o.getTaskId()));

        final DataConfigData taskConfigData = G.C.getTask(o.getTaskId());
        final PlayerTask.Builder taskBuilder = player.getPd().getTaskBuilder();
        final RunTask runTask = taskBuilder.getRunTaskMap().get(o.getTaskId());
        if (runTask != null) {
            return;
        }

        final RunTask.Builder data = RunTask.newBuilder();
        data.setTaskId(o.getTaskId());
        if (taskConfigData.completeType == 2) {// 立即完成
            data.setComplete(true);
            // push
            final int completeNpcId = taskConfigData.completeNpcId;

            if (completeNpcId != taskConfigData.npcId) {
                // 交任务的npc跟 接任务的npc不同
                // 前一个npc完成任务
                player.getTransport().send(MsgNo.TaskStatusChangePushNo_VALUE, TaskStatusChangePush.newBuilder()
                        .setNpcId(taskConfigData.npcId)
                        .setStatus(TaskStatusEnum.提交任务.id)
                        .setTaskId(o.getTaskId())
                        .setRunTask(data.buildPartial())
                        .build());
            }
            player.getTransport().send(MsgNo.TaskStatusChangePushNo_VALUE, TaskStatusChangePush.newBuilder()
                    .setNpcId(completeNpcId)
                    .setStatus(TaskStatusEnum.完成未提交.id)
                    .setTaskId(o.getTaskId())
                    .setRunTask(data.buildPartial())
                    .build()
            );
        } else {
            final List<Integer> targetList = taskConfigData.targetList;
            for (final Integer target : targetList) {
                data.addTarget(TaskService.makeTaskTarget(player, target));
            }
            boolean complete = true;

            for (TaskTarget.Builder builder : data.getTargetBuilderList()) {
                if (!builder.getComplete()) {
                    complete = false;
                    break;
                }
            }

            int status = complete ? TaskStatusEnum.完成未提交.id : TaskStatusEnum.接受任务.id;

            data.setComplete(complete);
            // push
            player.getTransport().send(MsgNo.TaskStatusChangePushNo_VALUE, TaskStatusChangePush.newBuilder()
                    .setTaskId(o.getTaskId())
                    .setNpcId(taskConfigData.npcId)
                    .setAccept(true)
                    .setStatus(status)// 接受任务
                    .setRunTask(data.buildPartial())
                    .build());
        }

        taskBuilder.putRunTask(o.getTaskId(), data.build());

    }

    /**
     * 完成任务
     *
     * @param player
     * @param o
     * @return
     */
    public static void completeTask(final Player player, final TaskReq req) {
        final PlayerTask.Builder taskBuilder = player.getPd().getTaskBuilder();
        if (!taskBuilder.getRunTaskMap().containsKey(req.getTaskId())) {
            return;
        }
        final RunTask runtask = taskBuilder.getRunTaskOrThrow(req.getTaskId());

        if (runtask.getComplete()) {
            final DataConfigData task = G.C.getTask(req.getTaskId());

            // 给奖励
            final List<Reward> make = RewardUtil.make(task.reward);
            // 检查物品
            final List<ItemData> collect = make.stream()
                    .filter(reward -> reward.getType() == RewardType.REWARD_ITEM)
                    .map(reward -> ItemData.newBuilder()
                            .setItemId(reward.getRewardId())
                            .setCount(reward.getCount())
                            .setProperty(reward.getProperty())
                            .build()).collect(Collectors.toList());

            ModuleAssert.isTrue(BagService.canPutReward(player, collect), ErrorEnum.ERR_104);

            // 消耗任务物品
            for (TaskTarget target : runtask.getTargetList()) {
                TaskTargetConfigData targetData = ConfigManager.taskTargetDataBox.findById(target.getId());
                if (targetData.type == TaskTargetTypeEnum.SEARCH.id) {
                    ItemConfigData item = ConfigManager.getItem(targetData.v1);
                    if (item.type != ItemTypeEnum.TASK) {
                        ModuleAssert.isTrue(BagService.removeItemFromBag(player, targetData.v1, targetData.v2), ErrorEnum.ERR_102);
                    }
                }
            }

            for (final Reward reward : make) {
                if (reward.getType() == RewardType.REWARD_RESOURCE) {

                    if (reward.getRewardId() == ResourceEnum.GOLD.id) {
                        // 金币
                        player.addGold(reward.getCount(), ResourceSourceEnum.任务);
                    }
                }
            }

            // 经验
            ExpConfigData exp = ConfigManager.getExp(task.level);
            player.addPlayerExp(exp.taskExp, ResourceSourceEnum.任务);


            for (final ItemData itemData : collect) {
                player.addItem(itemData, GameConstants.ITEM_BAG);
            }
            // 移除任务
            taskBuilder.removeRunTask(req.getTaskId());
            player.D.putCompleteTask(req.getTaskId(), true);

            // 推送变化
            player.getTransport().send(MsgNo.TaskStatusChangePushNo_VALUE, TaskStatusChangePush.newBuilder()
                    .setTaskId(runtask.getTaskId())
                    .setNpcId(task.completeNpcId)
                    .setStatus(TaskStatusEnum.提交任务.id)
                    .buildPartial());

            // 检查后续任务
            final Map<Integer, Boolean> completeTaskMap = player.D.getCompleteTaskMap();
            final List<Integer> afterTaskList = task.list2;

            final List<Integer> newTaskList = new ArrayList<>(2);

            if (afterTaskList != null) {

                c:
                for (final Integer afterTaskId : afterTaskList) {
                    final DataConfigData afterTask = G.C.getTask(afterTaskId);
                    if (afterTask == null) {
                        continue;
                    }

                    if (afterTask.level > player.pd.getLevel()) {
                        continue;
                    }
                    for (final Integer needCompleteTaskId : afterTask.list1) {
                        if (!completeTaskMap.containsKey(needCompleteTaskId)) {
                            break c;
                        }
                    }
                    newTaskList.add(afterTask.id);
                }
            }

            if (!newTaskList.isEmpty()) {
                // 新任务
                player.getTransport()
                        .send(MsgNo.TaskNewPushNo_VALUE,
                                TaskNewPush.newBuilder().addAllTaskId(newTaskList).buildPartial());
            }

            // event
            EventManager.firePlayerEvent(player, new TaskCompleteEvent(req.getTaskId()));

        }
    }

    /**
     * 找到npc任务
     *
     * @param player
     * @param req
     */
    public static TaskNpcRes TaskNpcReq(final Player player, final TaskNpcReq req) {
        final Collection<DataConfigData> npcTask = G.C.getNpcTask(req.getNpcId());

        if (npcTask != null && !npcTask.isEmpty()) {
            final TaskNpcRes.Builder builder = TaskNpcRes.newBuilder();
            builder.setNpcId(req.getNpcId());
            final Map<Integer, Boolean> completeTaskMap = player.D.getCompleteTaskMap();
            for (final DataConfigData data : npcTask) {
                if (data.level > player.pd.getLevel()) {
                    continue;
                }

                if (player.pd.getTaskBuilder().containsRunTask(data.id)) {
                    final RunTask runtask = player.pd.getTaskBuilder().getRunTaskOrThrow(data.id);
                    if (!runtask.getComplete()) {
                        builder.putRunTask(data.id, runtask);
                    }
                } else {
                    if (!completeTaskMap.containsKey(data.id)) {
                        boolean add = true;
                        if (data.list1 != null) {
                            for (final Integer beforeId : data.list1) {
                                if (!completeTaskMap.containsKey(beforeId)) {
                                    add = false;
                                    break;
                                }
                            }
                        }
                        if (add) {
                            builder.addAcceptableTask(data.id);
                        }
                    }
                }
            }

            for (final RunTask value : player.pd.getTaskBuilder().getRunTaskMap().values()) {
                if (value.getComplete()) {
                    final DataConfigData task = G.C.getTask(value.getTaskId());
                    if (task.completeNpcId == req.getNpcId()) {
                        builder.putRunTask(value.getTaskId(), value);
                    }
                }
            }
            return builder.build();
        }

        return null;
    }

    /**
     * 放弃任务
     *
     * @param player
     * @param req
     */
    public static TaskAbandonRes TaskAbandonReq(Player player, TaskAbandonReq req) {
        final PlayerTask.Builder taskBuilder = player.getPd().getTaskBuilder();
        final int taskId = req.getTaskId();
        if (!taskBuilder.getRunTaskMap().containsKey(taskId)) {
            return null;
        }

        player.pd.getTaskBuilder().removeRunTask(taskId);

        return TaskAbandonRes.newBuilder().setTaskId(req.getTaskId()).buildPartial();
    }
}