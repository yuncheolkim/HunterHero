package game.module.home;

import com.google.common.primitives.Ints;
import game.config.data.HomeItemConfigData;
import game.config.data.HomeLevelConfigData;
import game.config.data.HomeResourceConfigData;
import game.exception.ModuleAssert;
import game.game.enums.ResourceEnum;
import game.manager.ConfigManager;
import game.player.Player;
import game.proto.ResourceChangePush;
import game.proto.ValueChange;
import game.proto.data.*;
import game.proto.no.No;
import org.joda.time.DateTimeUtils;

/**
 * @author Yunzhe.Jin
 * 2021/8/2 14:39
 */
public class HomeService {
    private final static int MASK = 0xffff;

    public static HomePos fromInt(int pos) {
        int y = pos & MASK;
        int x = pos >> 16 & MASK;
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
    }

    /**
     * 放置物体
     *
     * @param player
     * @param data
     * @param rect
     */
    public static void put(Player player, HomePosData data, int pos) {
        long time = DateTimeUtils.currentTimeMillis();

        HomeItemConfigData d = ConfigManager.homeItemDataBox.findById(data.getId());

        if (data.getType() == HomeType.H_FARM) {
            data = data.toBuilder().setTime(time + d.time).buildPartial();
        }

        ModuleAssert.isTrue(isOpen(player, HomeAreaData.posToArea(pos)));
        HomePos homePos = fromInt(pos);

        HomeData.Builder homeDataBuilder = player.pd.getHomeDataBuilder();
        HomePosList.Builder build = HomePosList.newBuilder();
        if (homeDataBuilder.containsMapData(pos)) {
            build = homeDataBuilder.getMapDataOrThrow(pos).toBuilder();
        }

        build.setPos(pos);
        build.addData(data.toBuilder());
        homeDataBuilder.putMapData(pos, build.buildPartial());

        player.homeAreaData.addPosData(homePos.x, homePos.y, data);
    }

    /*d
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
        HomePosList.Builder builder = player.pd.getHomeDataBuilder().getMapDataOrThrow(pos).toBuilder();

        removeTileData(builder);

        player.pd.getHomeDataBuilder().putMapData(pos, builder.buildPartial());
    }

    public static void removeTileData(HomePosList.Builder builder) {
        builder.removeData(0);
    }


    /**
     * 收割
     *
     * @param player
     * @param pos
     */
    public static void harvest(Player player, int pos) {
        HomePosList d = player.pd.getHomeDataBuilder().getMapDataOrThrow(pos);
        HomePosList.Builder builder = d.toBuilder();
        HomePosData data = builder.getData(0);

        removeTileData(builder);
        player.pd.getHomeDataBuilder().removeMapData(pos);
        player.homeAreaData.harvest(pos);

        produceItem(player, data.getId(), 1);

    }

    /**
     * 收获物品
     *
     * @param player
     * @param id
     * @param count
     */
    private static void produceItem(Player player, int id, int count) {
        HomeResourceConfigData data = ConfigManager.homeResourceDataBox.findById(id);
        HomeData.Builder homeDataBuilder = player.pd.getHomeDataBuilder();

        // 物品
        if (data.inBag) {
            player.addItemToBag(ItemData.newBuilder().setItemId(id).setCount(count).build());
        } else {
            int cur = homeDataBuilder.getResourceCountOrDefault(id, 0);
            ModuleAssert.isTrue(cur + count <= homeDataBuilder.getResourceLimit());
            homeDataBuilder.putResourceCount(id, cur + count);

            player.send(No.HomeItemAddPush, ValueChange.newBuilder()
                    .setV1(id)
                    .setV2(count)
                    .buildPartial());
        }
        // 圆币
        final int old = homeDataBuilder.getCoin();
        long l = (long) data.coin * count;
        homeDataBuilder.setCoin(Ints.saturatedCast(old + l));
        if (old != homeDataBuilder.getCoin()) {
            player.send(No.ResourceChangePush, ResourceChangePush.newBuilder()
                    .setResourceId(ResourceEnum.HOME_COIN.id)
                    .setCurCount(homeDataBuilder.getCoin())
                    .setCount((int) l)
                    .buildPartial());
        }

        // 经验
        addHomeExp(player, count * data.exp);

    }

    private static void addHomeExp(Player player, int count) {
        HomeData.Builder homeDataBuilder = player.pd.getHomeDataBuilder();

        final int oldLevel = homeDataBuilder.getLevel();
        HomeLevelConfigData data = ConfigManager.homeLevelDataBox.findById(oldLevel);
        if (data == null) {
            return;
        }

        int exp = homeDataBuilder.getExp() + count;
        int level = oldLevel;
        int needExp = data.exp;

        while (exp >= needExp) {
            level++;
            // 升级
            exp -= needExp;
            data = ConfigManager.homeLevelDataBox.findById(level);
            if (data == null) {
                break;
            }
            needExp = ConfigManager.needExp(level);
        }

        player.send(No.ResourceChangePush, ResourceChangePush.newBuilder()
                .setResourceId(ResourceEnum.HOME_EXP.id)
                .setCurCount(homeDataBuilder.getExp())
                .setCount(count)
                .buildPartial());

        if (oldLevel != level) {
            player.send(No.HomeLevelChange, ValueChange.newBuilder()
                    .setV1(oldLevel)
                    .setV2(level)
                    .buildPartial());
            // todo 开启新功能
            homeDataBuilder.setLevel(level);

        }
    }
}
