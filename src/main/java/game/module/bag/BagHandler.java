package game.module.bag;

import game.base.Logs;
import game.base.constants.GameConstants;
import game.exception.ModuleAssert;
import game.module.player.Player;
import game.proto.BagCleanReq;
import game.proto.ItemDiscardReq;
import game.proto.ItemExchangeReq;
import game.proto.data.BagSlot;

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
    public static void clean(final Player player, final BagCleanReq req) {
        player.cleanBag(req.getType());
    }

    /**
     * 丢弃物品
     *
     * @param player
     * @param req
     */
    public static void discardItem(final Player player, final ItemDiscardReq req) {
        Logs.C.info("{}", req);
        player.removeBagItem(req.getType(), req.getCount(), req.getSlotId());
    }

    /**
     * 银行存取物品
     *
     * @param player
     * @param req
     */
    public static void exchangeItem(final Player player, final ItemExchangeReq req) {
        ModuleAssert.isPositive(req.getCount());
        if (req.getType() == 1) { // bank -> bag

            final BagSlot bagSlot = player.pd.getBankMap().get(req.getSlotId());
            ModuleAssert.notNull(bagSlot);
            final int count = Math.min(req.getCount(), bagSlot.getData().getCount());

            player.addItem(bagSlot.getData().toBuilder().setCount(count).build(), GameConstants.ITEM_BAG);

            player.removeBagItem(GameConstants.ITEM_BANK, count, req.getSlotId());

        } else {// bag -> bank
            final BagSlot bagSlot = player.pd.getBagMap().get(req.getSlotId());
            ModuleAssert.notNull(bagSlot);
            final int count = Math.min(req.getCount(), bagSlot.getData().getCount());

            player.addItem(bagSlot.getData().toBuilder().setCount(count).build(), GameConstants.ITEM_BANK);

            player.removeBagItem(GameConstants.ITEM_BAG, count, req.getSlotId());

        }
    }


}
