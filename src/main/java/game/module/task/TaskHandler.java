package game.module.task;

import game.anno.GameHandler;
import game.player.Player;
import game.proto.TaskReq;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 11:26
 */
public class TaskHandler {

    /**
     * 增加任务
     * @param player
     * @param o
     * @return
     */
    public static Object addTask(Player player, TaskReq o) {
        return null;
    }

    @GameHandler(no = 1002)
    public static Object findTask(Player player, TaskReq o) {
        return null;
    }

}
