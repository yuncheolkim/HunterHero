package game.module.home;

import game.exception.ModuleAssert;
import game.player.Player;
import game.proto.*;

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
        ModuleAssert.isTrue(req.getId() >= 0 && req.getId() <= player.homeAreaData.maxId());

        HomeService.openArea(player, req.getId());

        return req;
    }

    /**
     * 改变地形，如种植，造墙等
     * 优化：批量处理
     *
     * @param player
     */
    public static void change(Player player, HomeChangeReq req) {

        // todo
        HomeRectInfo rect = null;

        // consume resource

        ModuleAssert.isTrue(HomeService.canPut(player, req.getAreaId(), rect, req.getData().getType()));
        HomeService.put(player, req.getData(), rect);

    }

    /**
     * 收割
     *
     * @param player
     */
    public static HomeHarvestRes harvest(Player player, HomeHarvestReq req) {
        return null;
    }

    /**
     * 清理格子
     *
     * @param player
     * @param req
     */
    public static void clean(Player player, HomeCleanReq req) {
    }

}
