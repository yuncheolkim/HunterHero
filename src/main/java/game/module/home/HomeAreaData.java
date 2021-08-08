package game.module.home;

import game.proto.data.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Yunzhe.Jin
 * 2021/8/2 14:50
 */
public class HomeAreaData {
    private final static int row = 7;

    private final static int col = 7;

    private final static int size = 15;

    private HomePosList.Builder[][] pos = new HomePosList.Builder[105][105];

    public void init(HomeData.Builder homeData) {
        for (HomePosList value : homeData.getMapDataMap().values()) {
            HomePos homePos = HomeService.fromInt(value.getPos());
            pos[homePos.x][homePos.y] = value.toBuilder();
        }
    }

    public int maxId() {
        return row * col - 1;
    }

    /**
     * 是否可放置
     *
     * @param rect
     * @param type
     * @return
     */
    public boolean canPut(HomeRectInfo rect, HomeType type) {

        if (rect.x < 0 || rect.y < 0 || rect.x1 >= col * size || rect.y1 >= row * size) {
            return false;
        }

        for (int i = rect.x; i <= rect.x1; i++) {
            for (int j = rect.y; j <= rect.y1; j++) {
                HomePosList.Builder homePosData = pos[i][j];
                if (homePosData != null && checkConfilict(homePosData, type)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkConfilict(HomePosList.Builder homePosData, HomeType type) {
        Set<Integer> collect = homePosData.getDataList().stream().map(homePosData1 -> layer(homePosData1.getType())).collect(Collectors.toSet());
        return collect.contains(layer(type));
    }

    private int layer(HomeType type) {

        switch (type) {
            case H_FARM:
            case H_ROAD:
            case H_CARPET:
                return 1;
            case H_BUILD:
            case H_WALL:
                return 2;
        }

        return 0;

    }


    public HomeRectInfo calcRect(int areaId) {
        int x = areaId % col;
        int y = areaId / col;

        return new HomeRectInfo(HomeRect.newBuilder().setX(x * size).setY(y * size).buildPartial());
    }


    public boolean IsAContainB(HomeRectInfo a, HomeRectInfo b) {
        return b.x >= a.x &&
                b.y >= a.y &&
                b.x1 <= a.x1 &&
                b.y1 <= a.y1;
    }

    public void addPosData(int x, int y, HomePosData data) {
        HomePosList.Builder homePosList = pos[x][y];
        if (homePosList == null) {
            homePosList = HomePosList.newBuilder();
            pos[x][y] = homePosList;
        }
        homePosList.addData(data);
    }


    /**
     * 清理
     *
     * @param posIndex
     * @param type
     */
    public void clean(int posIndex) {
        HomePos homePos = HomeService.fromInt(posIndex);
        HomeService.removeTileData(pos[homePos.x][homePos.y]);
    }

    /**
     * 收割
     *
     * @param pos
     */
    public void harvest(int index) {
        HomePos homePos = HomeService.fromInt(index);
        pos[homePos.x][homePos.y] = null;
    }

    /**
     * 查询区域所在area
     *
     * @param rect
     * @return
     */
    public Set<Integer> findArea(HomeRectInfo rect) {
        Set<Integer> set = new HashSet<>();

        set.add(posToArea(rect.x));
        set.add(posToArea(rect.x1));
        set.add(posToArea(rect.y));
        set.add(posToArea(rect.y1));

        return set;
    }

    /**
     * 返回pos 位置坐在的区域id
     *
     * @param pos
     * @return
     */
    public static int posToArea(int pos) {
        HomePos homePos = HomeService.fromInt(pos);
        int x = homePos.x / size;
        int y = homePos.y / size;
        return x + y * col;
    }
}
