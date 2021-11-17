package game.module.task.accept;

import game.base.G;
import game.config.base.DataConfigData;
import game.module.player.Player;

/**
 * 简单通用检查：
 * 等级
 *
 * @author Yunzhe.Jin
 * 2021/5/12 11:33
 */
public class TaskCommonAccept implements ITaskAccept {
    @Override
    public boolean acceptable(Player player, int taskId) {

        DataConfigData data = G.C.getTask(taskId);


        return player.pd.getLevel() >= data.level;
    }
}
