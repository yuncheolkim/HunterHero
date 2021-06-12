package game.module.event.handler;

import game.config.base.DataConfigData;
import game.game.ResourceSourceEnum;
import game.manager.ConfigManager;
import game.manager.EventManager;
import game.module.event.IPlayerEventHandler;
import game.module.task.TaskService;
import game.player.Player;
import game.proto.PlayerLevelChangePush;
import game.proto.TaskNewPush;
import game.proto.back.MsgNo;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Yunzhe.Jin
 * 2021/3/7 16:05
 */
public class LevelUpEventHandler implements IPlayerEventHandler<LevelUpEvent> {
    @Override
    public void handler(final Player player, final LevelUpEvent data) {

        if (data.heroId > 0) {
            // 英雄战力计算
            EventManager.firePlayerEvent(player, new HeroPowerUpEvent(data.heroId));
        } else {
            // push
            player.getTransport().send(MsgNo.PlayerLevelChangePushNo_VALUE, PlayerLevelChangePush.newBuilder().setValue(data.level).build());

            // 计算体力
            player.setMaxPower(ConfigManager.GetInitPower() + data.level);
            player.resetPower(ResourceSourceEnum.升级);

            // 查找新任务
            List<Integer> levelTask = TaskService.findLevelTask(player);
            if (!levelTask.isEmpty()) {
                final Map<Integer, Boolean> completeTaskMap = player.D.getCompleteTaskMap();

                levelTask = levelTask.stream().filter(taskId -> {
                    DataConfigData dataConfigData = ConfigManager.taskMap4.get(taskId);

                    if (!CollectionUtils.isEmpty(dataConfigData.list1)) {

                        return dataConfigData.list1.stream().allMatch(completeTaskMap::containsKey);
                    }
                    return true;

                }).collect(Collectors.toList());

                if (!levelTask.isEmpty()) {
                    // 新任务
                    player.getTransport()
                            .send(MsgNo.TaskNewPushNo_VALUE,
                                    TaskNewPush.newBuilder().addAllTaskId(levelTask).buildPartial());
                }
            }
        }
    }
}
