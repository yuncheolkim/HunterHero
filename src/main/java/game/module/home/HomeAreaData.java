package game.module.home;

import game.proto.data.HomeData;
import game.proto.data.HomePosData;
import game.proto.data.HomeRect;
import game.proto.data.HomeType;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yunzhe.Jin
 * 2021/8/2 14:50
 */
public class HomeAreaData {
    private final static int row = 7;

    private final static int col = 7;

    private final static int size = 15;

    private HomePosData[][] pos = new HomePosData[105][105];

    public void init(HomeData.Builder homeData) {
        for (HomePosData value : homeData.getMapDataMap().values()) {
            HomePos homePos = HomeService.fromInt(value.getPos());
            pos[homePos.x][homePos.y] = value;
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

        if (rect.x < 0 || rect.y < 0 || rect.x1 >= col * 7 || rect.y1 >= row * size) {
            return false;
        }

        for (int i = rect.x; i < rect.x1; i++) {
            for (int j = rect.y; j < rect.y1; j++) {
                HomePosData homePosData = pos[i][j];
                if (homePosData == null) {
                    return false;
                }

                HomeType curType = homePosData.getType();

                if (curType != HomeType.H_NONE) {

                    if (curType == HomeType.H_LAND && type != HomeType.H_FARM) {
                        return false;
                    }
                }
            }
        }
        return true;
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
        pos[x][y] = data;
    }


    /**
     * 清理
     *
     * @param posIndex
     */
    public void clean(int posIndex) {

        HomePos homePos = HomeService.fromInt(posIndex);
        pos[homePos.x][homePos.y] = HomePosData.newBuilder()
                .setPos(posIndex)
                .setType(HomeType.H_NONE).buildPartial();
    }

    /**
     * 收割
     *
     * @param pos
     */
    public void harvest(int pos) {

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
    private static int posToArea(int pos) {
        HomePos homePos = HomeService.fromInt(pos);
        int x = homePos.x / size;
        int y = homePos.y / size;
        return x + y * col;
    }
}
