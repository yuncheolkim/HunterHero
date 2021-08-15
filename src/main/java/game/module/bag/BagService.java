package game.module.bag;

import game.player.Player;
import game.proto.BagInfoChangePush;
import game.proto.data.BagSlot;
import game.proto.data.ItemData;
import game.proto.no.No;

import java.util.Collection;
import java.util.List;

import static game.module.bag.BagUpdateService.updatePlayerBank;

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

    public static boolean hasOne(Player player) {

        return player.bag.remain() > 0;
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


    /**
     * 获取item 背包内总数量
     *
     * @param itemId
     * @return
     */
    public static int itemBagCount(Player player, int itemId) {
        int count = 0;

        Collection<BagSlot> bagSlots = player.bag.bagSlotMap.get(itemId);
        if (!bagSlots.isEmpty()) {
            for (BagSlot bagSlot : bagSlots) {
                count += bagSlot.getData().getCount();
            }
        }

        return count;
    }

    /**
     * 从背包移除物品
     *
     * @param player
     * @param itemId
     * @param count
     * @return
     */
    public static boolean removeItemFromBag(Player player, int itemId, int count) {
        List<BagSlot> bagSlots = findBagUpdateService(1).removeItem(player, itemId, count);

        for (BagSlot bagSlot : bagSlots) {

            final BagInfoChangePush.Builder builder = BagInfoChangePush.newBuilder().setType(1);
            builder.addSlot(bagSlot);
            player.send(No.BagInfoChangePush, builder.build());
        }

        return !bagSlots.isEmpty();
    }

    public static BagUpdateService findBagUpdateService(final int type) {
        if (type == 1) {
            return BagUpdateService.updatePlayerBag;
        }
        return updatePlayerBank;
    }
}
