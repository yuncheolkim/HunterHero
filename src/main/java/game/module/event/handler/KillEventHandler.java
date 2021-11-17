package game.module.event.handler;

import game.module.event.IPlayerEventHandler;
import game.module.task.TaskService;
import game.module.task.TaskTargetTypeEnum;
import game.module.player.Player;

/**
 * @author Yunzhe.Jin
 * 2021/3/8 15:27
 */
public class KillEventHandler implements IPlayerEventHandler<KillEvent> {
    @Override
    public void handler(Player player, KillEvent data) {

        // 记录任务
        TaskService.calcTaskProcess(player, data.targetId, data.count, TaskTargetTypeEnum.KILL);
    }
}
