package game.module.bag;

import game.player.Player;
import game.proto.data.ItemData;

import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/3/26 22:48
 */
public class BagService {

    /**
     * 是否可以放入物品
     * 只检查容量
     *
     * @param player
     * @return
     */
    public static boolean canPutReward(Player player, List<ItemData> items) {

        if (items.isEmpty()) {
            return true;
        }

        return player.bag.remain() >= items.size();
    }
}
