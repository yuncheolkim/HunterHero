package game.module.home;

import game.config.data.HomeItemConfigData;
import game.exception.ModuleAssert;
import game.manager.ConfigManager;
import game.player.Player;
import game.proto.*;
import game.proto.data.HomePosData;
import game.proto.data.HomeRect;

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

        for (HomePosData homePosData : req.getDataList()) {

            HomeItemConfigData d = ConfigManager.homeItemDataBox.findById(homePosData.getType().getNumber() * 100 + homePosData.getId());
            HomePos homePos = HomeService.fromInt(homePosData.getPos());
            HomeRectInfo rect = new HomeRectInfo(homePos.x, homePos.y, d.w, d.h);

            // consume resource
            ModuleAssert.isTrue(HomeService.canPut(player, rect, homePosData.getType()));

            rect.foreach((x, y) -> {
                HomeService.put(player, homePosData, HomeService.fromPos(x, y));
            });
        }
    }

    /**
     * 收割
     *
     * @param player
     */
    public static HomeHarvestRes harvest(Player player, HomeHarvestReq req) {

        req.getPosList().forEach(pos -> HomeService.harvest(player, pos));

        return null;
    }

    /**
     * 清理格子
     *
     * @param player
     * @param req
     */
    public static void clean(Player player, HomeCleanReq req) {
        for (HomeRect homeRect : req.getRectList()) {
            HomeService.clean(player, new HomeRectInfo(homeRect), req.getType());
        }
    }

}
