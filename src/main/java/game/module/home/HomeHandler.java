package game.module.home;

import game.anno.GameHandler;
import game.base.Logs;
import game.config.data.HomeBuildConfigData;
import game.config.data.HomeItemConfigData;
import game.config.data.HomeResourceConfigData;
import game.config.data.HomeTaskConfigData;
import game.exception.ModuleAssert;
import game.game.enums.ResourceEnum;
import game.manager.ConfigManager;
import game.module.bag.BagService;
import game.module.player.Player;
import game.proto.*;
import game.proto.data.HomeData;
import game.proto.data.HomePosData;
import game.proto.no.No;

import java.util.List;

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
    @GameHandler(No.HomeOpenAreaRqRs)
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
    @GameHandler(No.HomeChangeReq)
    public static void change(Player player, HomeChangeReq req) {

        int[] count = new int[]{0};
        for (HomePosData homePosData : req.getDataList()) {

            HomeItemConfigData d = ConfigManager.homeItemDataBox.findById(homePosData.getId());
            HomePos homePos = HomeService.fromInt(homePosData.getPos());
            HomeRectInfo rect = new HomeRectInfo(homePos.x, homePos.y, d.w, d.h);

            // consume resource
            ModuleAssert.isTrue(HomeService.canPut(player, rect, homePosData.getType()));

            rect.foreach((x, y) -> {
                count[0] += HomeService.put(player, homePosData, HomeService.fromPos(x, y));
            });


        }
        if (count[0] != 0) {
            player.send(No.ResourceChangePush, ResourceChangePush.newBuilder()
                    .setResourceId(ResourceEnum.HOME_COIN.id)
                    .setCurCount(player.pd.getHomeDataBuilder().getCoin())
                    .setCount((int) count[0] * -1)
                    .buildPartial());
        }
    }

    /**
     * 收割
     *
     * @param player
     */
    @GameHandler(No.HomeHarvestReq)
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
    @GameHandler(No.HomeCleanReq)
    public static void clean(Player player, HomeCleanReq req) {
        for (Integer pos : req.getPosList()) {
            HomeService.clean(player, pos);
        }
    }

    /**
     * 升级厨房
     */
    @GameHandler(No.HomeUpgradeCookReq)
    public static void upgradeCook(Player player) {

        HomeData.Builder homeDataBuilder = player.pd.getHomeDataBuilder();
        final int cookLevel = homeDataBuilder.getCookLevel();
        HomeBuildConfigData data = ConfigManager.homeBuildDataBox.findById(200 + cookLevel);
        if (data.needCoin > 0) {
            HomeService.consumeCoin(player, data.needCoin);
            homeDataBuilder.setCookLevel(cookLevel + 1);
        }
    }

    /**
     * 生产
     *
     * @param player
     * @param req
     */
    @GameHandler(No.HomeProductReq)
    public static void product(Player player, HomeProductReq req) {

        if (req.getType() == 1) {

            HomeService.productCook(player, req.getProductId());
        }
    }

    /**
     * 完成任务
     *
     * @param player
     * @param req
     */
    @GameHandler(No.HomeTaskCompleteReq)
    public static void taskComplete(Player player, HomeTaskCompleteReq req) {
        final int id = req.getId();
        HomeTaskConfigData data = ConfigManager.homeTaskDataBox.findById(id);

        HomeData.Builder builder = player.pd.getHomeDataBuilder();

        if (builder.containsCompleteTask(id)) {
            // 已经完成
            return;
        }
        int taskDay = builder.getTaskDay();
        List<HomeTaskConfigData> dayTaskList = ConfigManager.homeTaskDataBox.findByCollectId(taskDay);
        if (dayTaskList.stream().noneMatch(homeTaskConfigData -> homeTaskConfigData.id == id)) {
            Logs.C.warn("不是今天的任务:{}", id);
            // 没有任务
            return;
        }

        HomeResourceConfigData item = ConfigManager.homeResourceDataBox.findById(data.itemId);


        if (item.inBag) {
            BagService.removeItemFromBag(player, item.id, data.count);
        } else {
            HomeService.reduceItem(player, item.id, data.count);
        }
        // 经验
        HomeService.addHomeExp(player, data.exp);
        // 园币
        HomeService.addCoin(player, data.coin);

        builder.putCompleteTask(id, 1);

        if (builder.getCompleteTaskCount() == dayTaskList.size()) {
            // 下一天任务
            builder.clearCompleteTask();
            builder.setTaskDay(builder.getTaskDay() + 1);
            player.send(No.HomeNewTaskDayPush, HomeNewTaskDayPush.newBuilder().setDay(builder.getTaskDay()));
        }

    }
}
