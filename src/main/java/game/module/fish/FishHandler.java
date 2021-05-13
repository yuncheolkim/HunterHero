package game.module.fish;

import game.player.Player;
import game.proto.FishPush;
import game.proto.FishReq;
import game.proto.no.No;

/**
 * 钓鱼系统
 *
 * @author Yunzhe.Jin
 * 2021/4/15 15:28
 */
public class FishHandler {

    /**
     * 钓鱼
     *
     * @param player
     * @param req
     */
    public static void fish(Player player, FishReq req) {

        // todo 检查是否在钓鱼区域

        if (player.fishing) {
            //失败
            player.getTransport().send(
                    No.FishReq_VALUE,
                    FishPush.newBuilder().setSuccess(false).buildPartial()
            );
        } else {
            // todo 消耗体力

        }

    }


    /**
     * inner
     *
     * @param player
     * @param req
     * @return
     */
    public static void fishEnd(Player player) {

    }

}
