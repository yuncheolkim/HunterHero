package game.module.bag;

import game.base.Logs;
import game.player.Player;
import game.proto.BagCleanReq;
import game.proto.ItemDiscardReq;

/**
 * @author Yunzhe.Jin
 * 2021/3/12 14:12
 */
public class BagHandler {

    public static void clean(Player player, BagCleanReq req) {
        if (req.getType() == 1) {
            player.cleanBag();
        }
    }

    /**
     * 丢弃物品
     *
     * @param player
     * @param req
     */
    public static void discardItem(Player player, ItemDiscardReq req) {
        Logs.C.info("{}", req);
        if (req.getType() == 1) {
            player.discardBagItem(req.getItemId(), req.getCount(), req.getSlotId());

        }
    }


}
