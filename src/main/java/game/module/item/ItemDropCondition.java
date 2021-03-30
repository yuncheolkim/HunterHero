package game.module.item;

import game.player.Player;

/**
 * 掉落物品条件
 *
 * @author Yunzhe.Jin
 * 2021/3/27 15:49
 */
public interface ItemDropCondition {


    boolean drop(Player player, int enemyId);

}
