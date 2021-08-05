package game.module.home;

import game.exception.ModuleAssert;
import game.player.Player;
import game.proto.data.HomeData;
import game.proto.data.HomePosData;
import game.proto.data.HomeType;

/**
 * @author Yunzhe.Jin
 * 2021/8/2 14:39
 */
public class HomeService {
    private final static int X_MASK = 0xffff0000;

    private final static int Y_MASK = 0xffff;

    public static HomePos fromInt(int pos) {
        int y = pos & Y_MASK;
        int x = pos >> 16 & X_MASK;
        return new HomePos(x, y);
    }

    public static int fromPos(HomePos pos) {
        return fromPos(pos.x, pos.y);
    }

    public static int fromPos(int x, int y) {
        return x << 16 | y;
    }


    /**
     * 初始化房间数据
     *
     * @param player
     * @return
     */
    public static HomeAreaData initHomeAreaData(Player player) {
        HomeAreaData homeAreaData = new HomeAreaData();

        HomeData.Builder homeData = player.pd.getHomeDataBuilder();
        if (homeData != null) {
            homeAreaData.init(homeData);
        }

        return homeAreaData;
    }

    /**
     * 能否放置
     *
     * @param player
     * @param areaId
     * @param rect
     * @return
     */
    public static boolean canPut(Player player, HomeRectInfo rect, HomeType type) {


        boolean result = true;//isOpen(player, areaId);

        if (result) {
            HomeAreaData homeAreaData = player.homeAreaData;
            result = homeAreaData.canPut(rect, type);
        }
        return result;
    }

    /**
     * 是否开启区域
     *
     * @param player
     * @param areaId
     * @return
     */
    public static boolean isOpen(Player player, int areaId) {
        return (player.pd.getHomeData().getOpenArea() & 1L << areaId) != 0;
    }

    /**
     * 开启区域
     *
     * @param player
     * @param areaId
     */
    public static void openArea(Player player, int areaId) {
        if (isOpen(player, areaId)) {
            return;
        }
        HomeData.Builder homeDataBuilder = player.pd.getHomeDataBuilder();
        homeDataBuilder.setOpenArea(homeDataBuilder.getOpenArea() | 1L << areaId);
        HomeRectInfo r = player.homeAreaData.calcRect(areaId);

        r.foreach((i, j) -> {
            HomePosData d = HomePosData.newBuilder()
                    .setPos(fromPos(i, j))
                    .setType(HomeType.H_NONE)
                    .buildPartial();
            homeDataBuilder.putMapData(d.getPos(), d);
            player.homeAreaData.addPosData(i, j, d);
        });
    }

    /**
     * 放置物体
     *
     * @param player
     * @param data
     * @param rect
     */
    public static void put(Player player, HomePosData data, HomeRectInfo rect) {

        for (Integer areaId : player.homeAreaData.findArea(rect)) {
            ModuleAssert.isTrue(isOpen(player, areaId));
        }

        HomeData.Builder homeDataBuilder = player.pd.getHomeDataBuilder();
        rect.foreach((i, j) -> {
            homeDataBuilder.putMapData(data.getPos(), data);
            player.homeAreaData.addPosData(i, j, data);
        });
    }

    /**
     * 清理地图上的建筑，物品
     *
     * @param player
     * @param rect
     */
    public static void clean(Player player, HomeRectInfo rect) {

        for (int i = rect.x; i <= rect.x1; i++) {
            for (int j = rect.y; j < rect.y1; j++) {
                clean(player, fromPos(i, j));
            }
        }

    }

    public static void clean(Player player, int pos) {
        player.homeAreaData.clean(pos);
        HomePosData.Builder mapDataOrThrow = player.pd.getHomeDataBuilder().getMapDataOrThrow(pos).toBuilder();

        clean(mapDataOrThrow);

        player.pd.getHomeDataBuilder().putMapData(pos, mapDataOrThrow.buildPartial());
    }

    /**
     * 清除格子内容
     *
     * @param builder
     */
    private static void clean(HomePosData.Builder builder) {
        // todo 返还资源
        builder.setType(HomeType.H_NONE);
        builder.clearBody();
    }

    /**
     * 收割
     *
     * @param player
     * @param pos
     */
    public static void harvest(Player player, int pos) {
        HomePosData d = player.pd.getHomeDataBuilder().getMapDataOrThrow(pos);
        HomePosData.Builder builder = d.toBuilder();
        builder.setType(HomeType.H_LAND);
        builder.clearBody();
        player.homeAreaData.harvest(pos);
    }
}
