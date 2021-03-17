package game.module.bag;

import game.base.Logs;
import game.player.Player;
import game.proto.BagCleanReq;
import game.proto.ItemDiscardReq;
import game.proto.ItemExchangeReq;

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
        if (req.getType() == 1) {


        } else {

        }
    }


}
