package game.module.home;

import game.exception.ModuleAssert;
import game.player.Player;
import game.proto.HomeChangeReq;
import game.proto.HomeHarvestReq;
import game.proto.HomeOpenAreaRqRs;

/**
 * 家园系统
 *
 * @author Yunzhe.Jin
 * 2021/4/15 15:27
 */
public class HomeHandler {

    /**
     * 开启区域
     *
     * @param player
     */
    public static HomeOpenAreaRqRs openArea(Player player, HomeOpenAreaRqRs req) {
        ModuleAssert.isTrue(req.getId() >= 0 && req.getId() < 49);

        HomeService.openArea(player, req.getId());

        return req;
    }

    /**
     * 改变地形，如种植，造墙等
     *
     * @param player
     */
    public static void change(Player player, HomeChangeReq req) {

    }

    /**
     * 收割
     *
     * @param player
     */
    public static void harvest(Player player, HomeHarvestReq req) {

    }
}
