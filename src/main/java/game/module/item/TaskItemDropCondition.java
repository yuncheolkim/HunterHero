package game.module.item;

import game.player.Player;

/**
 * 掉落物品条件
 *
 * @author Yunzhe.Jin
 * 2021/3/27 15:49
 */
public class TaskItemDropCondition implements ItemDropCondition {


    @Override
    public boolean drop(Player player, int itemId) {


        return false;
    }
}
