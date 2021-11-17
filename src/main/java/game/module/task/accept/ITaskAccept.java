package game.module.task.accept;

import game.module.player.Player;

/**
 * 检查任务是否可接受
 *
 * @author Yunzhe.Jin
 * 2021/5/12 11:34
 */
public interface ITaskAccept {

    /**
     * 检查任务是否可以接受
     *
     * @param player
     * @param taskId
     * @return
     */
    boolean acceptable(Player player, int taskId);
}
