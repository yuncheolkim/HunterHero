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
import game.proto.TaskNewPush;
import game.proto.TaskNpcReq;
import game.proto.TaskNpcRes;
import game.proto.TaskReq;
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

        DataConfigData taskConfigData4 = G.C.taskMap4.get(o.getTaskId());
        RunTask.Builder data = RunTask.newBuilder();
        data.setTaskId(o.getTaskId());
        if (taskConfigData4.completeType == 2) {// 立即完成
            data.setComplete(true);
        }
        player.getPd().getTaskBuilder().putRunTask(o.getTaskId(), data.build());

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
                    builder.putRunTask(data.id, player.pd.getTaskBuilder().getRunTaskOrThrow(data.id));
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
        }

        return builder.build();
    }
}