package game.module.bag;

import game.player.Player;
import game.proto.BagCleanReq;

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

}
