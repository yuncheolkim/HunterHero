package game.module.home;

import game.proto.data.HomeData;
import game.proto.data.HomePosData;
import game.proto.data.HomeRect;
import game.proto.data.HomeType;

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

        for (HomePosData homePosData : homeData.getMapDataList()) {
            HomePos homePos = HomeService.fromInt(homePosData.getPos());
            pos[homePos.x][homePos.y] = homePosData;
        }
    }

    /**
     * 是否可放置
     *
     * @param rect
     * @return
     */
    public boolean canPut(HomeRectInfo rect) {
        for (int i = rect.x; i < rect.x1; i++) {
            for (int j = rect.y; j < rect.y1; j++) {
                HomePosData homePosData = pos[i][j];
                if (homePosData == null || homePosData.getType() != HomeType.H_NONE) {
                    return false;
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

}
