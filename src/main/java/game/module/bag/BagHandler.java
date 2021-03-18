package game.module.bag;

import game.base.GameConstants;
import game.base.Logs;
import game.exception.ModuleAssert;
import game.player.Player;
import game.proto.BagCleanReq;
import game.proto.ItemDiscardReq;
import game.proto.ItemExchangeReq;
import game.proto.data.BagSlot;
import game.proto.data.ItemData;

/**
 * @author Yunzhe.Jin
 * 2021/3/12 14:12
 */
public class BagHandler {

    /**
     * 整理
     *
     * @param player
     * @param req
     */
    public static void clean(Player player, BagCleanReq req) {
        player.cleanBag(req.getType());
    }

    /**
     * 丢弃物品
     *
     * @param player
     * @param req
     */
    public static void discardItem(Player player, ItemDiscardReq req) {
        Logs.C.info("{}", req);
        player.removeBagItem(req.getType(), req.getCount(), req.getSlotId());
    }

    /**
     * 银行存取物品
     *
     * @param player
     * @param req
     */
    public static void exchangeItem(Player player, ItemExchangeReq req) {
        ModuleAssert.isPositive(req.getCount());
        if (req.getType() == 1) { // bank -> bag

            BagSlot bagSlot = player.pd.getBankMap().get(req.getSlotId());
            ModuleAssert.notNull(bagSlot);
            int count = Math.min(req.getCount(), bagSlot.getData().getCount());

            player.addItem(ItemData.newBuilder().setCount(count).setItemId(bagSlot.getData().getItemId()).build(), GameConstants.ITEM_BAG);

            player.removeBagItem(GameConstants.ITEM_BANK, count, req.getSlotId());

        } else {// bag -> bank
            BagSlot bagSlot = player.pd.getBagMap().get(req.getSlotId());
            ModuleAssert.notNull(bagSlot);
            int count = Math.min(req.getCount(), bagSlot.getData().getCount());

            player.addItem(ItemData.newBuilder().setCount(count).setItemId(bagSlot.getData().getItemId()).build(), GameConstants.ITEM_BANK);

            player.removeBagItem(GameConstants.ITEM_BAG, count, req.getSlotId());

        }
    }


}
