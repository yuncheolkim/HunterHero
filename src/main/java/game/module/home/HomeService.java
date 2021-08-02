package game.module.home;

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
    public static boolean canPut(Player player, int areaId, HomeRectInfo rect) {

        boolean result = isOpen(player, areaId);

        if (result) {
            HomeAreaData homeAreaData = player.homeAreaData;
            result = homeAreaData.canPut(rect);
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
        for (int i = r.x; i < r.x1; i++) {
            for (int j = r.y; j < r.y1; j++) {
                HomePosData d = HomePosData.newBuilder()
                        .setPos(fromPos(i, j))
                        .setType(HomeType.H_NONE)
                        .buildPartial();
                homeDataBuilder.addMapData(d);
                player.homeAreaData.addPosData(i, j, d);
            }
        }
    }
}
