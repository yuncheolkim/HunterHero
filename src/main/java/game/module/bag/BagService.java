package game.module.bag;

import game.player.Player;
import game.proto.data.BagSlot;
import game.proto.data.ItemData;

import java.util.Collection;
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


    /**
     * 获取item 总数量，包括背包银行
     *
     * @param itemId
     * @return
     */
    public static int itemAllCount(Player player, int itemId) {
        int count = 0;

        Collection<BagSlot> bagSlots = player.bag.bagSlotMap.get(itemId);
        if (!bagSlots.isEmpty()) {
            for (BagSlot bagSlot : bagSlots) {
                count += bagSlot.getData().getCount();
            }
        }
        Collection<BagSlot> bankSlots = player.bank.bagSlotMap.get(itemId);
        if (!bagSlots.isEmpty()) {
            for (BagSlot bagSlot : bankSlots) {
                count += bagSlot.getData().getCount();
            }
        }


        return count;
    }
}
