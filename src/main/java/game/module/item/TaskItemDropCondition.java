package game.module.item;

import game.player.Player;

/**
 * 任务物品掉落
 *
 * @author Yunzhe.Jin
 * 2021/3/27 15:49
 */
public class TaskItemDropCondition implements ItemDropCondition {


    @Override
    public boolean drop(Player player, int enemyId) {


        return false;
    }
}
