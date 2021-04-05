package game.module.task;

import game.base.G;
import game.base.GameConstants;
import game.config.DataConfigData;
import game.exception.ErrorEnum;
import game.exception.ModuleAssert;
import game.game.ResourceEnum;
import game.game.ResourceSourceEnum;
import game.module.bag.BagService;
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
    public static void acceptTask(Player player, TaskReq o) {

        ModuleAssert.isTrue(TaskService.canAcceptTask(player, o.getTaskId()));

        DataConfigData taskConfigData = G.C.getTask(o.getTaskId());
        PlayerTask.Builder taskBuilder = player.getPd().getTaskBuilder();
        RunTask.Builder data = RunTask.newBuilder();
        data.setTaskId(o.getTaskId());
        if (taskConfigData.completeType == 2) {// 立即完成
            data.setComplete(true);
            // push
            player.getTransport().send(MsgNo.TaskStatusChangePushNo_VALUE, TaskStatusChangePush.newBuilder()
                    .setNpcId(taskConfigData.completeNpcId)
                    .setComplete(true)
                    .setStatus(1)
                    .setTaskId(o.getTaskId())
                    .setRunTask(data.buildPartial())
                    .build()
            );
        } else {
            List<Integer> targetList = taskConfigData.targetList;
            for (Integer target : targetList) {
                data.addTarget(TaskTarget.newBuilder().setId(target).build());
            }

            // push
            player.getTransport().send(MsgNo.TaskStatusChangePushNo_VALUE, TaskStatusChangePush.newBuilder()
                    .setTaskId(o.getTaskId())
                    .setNpcId(taskConfigData.npcId)
                    .setAccept(true)
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
    public static void completeTask(Player player, TaskReq req) {
        PlayerTask.Builder taskBuilder = player.getPd().getTaskBuilder();
        RunTask runtask = taskBuilder.getRunTaskOrThrow(req.getTaskId());

        if (runtask.getComplete()) {
            // 给奖励
            DataConfigData task = G.C.getTask(req.getTaskId());

            List<Reward> make = RewardUtil.make(task.reward);
            // 检查物品
            List<ItemData> collect = make.stream()
                    .filter(reward -> reward.getType() == RewardType.REWARD_ITEM)
                    .map(reward -> ItemData.newBuilder()
                            .setItemId(reward.getRewardId())
                            .setCount(reward.getCount())
                            .build()).collect(Collectors.toList());

            ModuleAssert.isTrue(BagService.canPutReward(player, collect), ErrorEnum.ERR_104);

            for (Reward reward : make) {
                if (reward.getType() == RewardType.REWARD_RESOURCE) {

                    if (reward.getRewardId() == ResourceEnum.GOLD.id) {
                        // 金币
                        player.addGold(reward.getCount(), ResourceSourceEnum.任务);
                    } else if (reward.getRewardId() == ResourceEnum.EXP.id) {
                        // 经验
                        player.addPlayerExp(reward.getCount(), ResourceSourceEnum.任务);
                    }
                }
            }

            for (ItemData itemData : collect) {
                player.addItem(itemData, GameConstants.ITEM_BAG);
            }
            // 移除任务
            taskBuilder.removeRunTask(req.getTaskId());
            player.D.putCompleteTask(req.getTaskId(), true);

            // 推送变化
            player.getTransport().send(MsgNo.TaskStatusChangePushNo_VALUE, TaskStatusChangePush.newBuilder()
                    .setTaskId(runtask.getTaskId())
                    .setNpcId(task.completeNpcId)
                    .setComplete(true)
                    .setStatus(2)
                    .buildPartial());

            // 检查后续任务
            Map<Integer, Boolean> completeTaskMap = player.D.getCompleteTaskMap();
            List<Integer> afterTaskList = task.list2;

            List<Integer> newTaskList = new ArrayList<>(2);

            for (Integer afterTaskId : afterTaskList) {
                DataConfigData afterTask = G.C.getTask(afterTaskId);
                for (Integer needCompleteTaskId : afterTask.list1) {
                    if (!completeTaskMap.containsKey(needCompleteTaskId)) {
                        break;
                    }
                }
                newTaskList.add(afterTask.id);
            }

            if (!newTaskList.isEmpty()) {
                // 新任务
                player.getTransport()
                        .send(MsgNo.TaskNewPushNo_VALUE,
                                TaskNewPush.newBuilder().addAllTaskId(newTaskList).buildPartial());
            }
        }
    }

    /**
     * 找到npc任务
     *
     * @param player
     * @param req
     */
    public static TaskNpcRes findNpcTask(Player player, TaskNpcReq req) {
        TaskNpcRes.Builder builder = TaskNpcRes.newBuilder();
        builder.setNpcId(req.getNpcId());
        Collection<DataConfigData> npcTask = G.C.getNpcTask(req.getNpcId());

        if (npcTask != null) {
            Map<Integer, Boolean> completeTaskMap = player.D.getCompleteTaskMap();
            for (DataConfigData data : npcTask) {
                if (data.level > player.pd.getLevel()) {
                    continue;
                }

                if (player.pd.getTaskBuilder().containsRunTask(data.id)) {
                    RunTask runtask = player.pd.getTaskBuilder().getRunTaskOrThrow(data.id);
                    if (!runtask.getComplete()) {
                        builder.putRunTask(data.id, runtask);
                    }
                } else {
                    if (!completeTaskMap.containsKey(data.id)) {
                        boolean add = true;
                        if (data.list1 != null) {
                            for (Integer beforeId : data.list1) {
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

            for (RunTask value : player.pd.getTaskBuilder().getRunTaskMap().values()) {
                if (value.getComplete()) {
                    DataConfigData task = G.C.getTask(value.getTaskId());
                    if (task.completeNpcId == req.getNpcId()) {
                        builder.putRunTask(value.getTaskId(), value);
                    }
                }
            }
        }

        return builder.build();
    }
}