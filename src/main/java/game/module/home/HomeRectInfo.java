package game.module.home;

import game.proto.data.HomeRect;

import java.util.function.BiConsumer;

/**
 * @author Yunzhe.Jin
 * 2021/8/2 14:38
 */
public class HomeRectInfo {
    public final int x;

    public final int y;

    public final int w;

    public final int h;

    public final int x1;

    public final int y1;

    public HomeRectInfo(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        x1 = x + w - 1;
        y1 = y + h - 1;
    }

    public HomeRectInfo(HomeRect rect) {

        x = rect.getX();
        y = rect.getY();
        w = rect.getW();
        h = rect.getH();
        x1 = x + w - 1;
        y1 = h + h - 1;
    }

    public HomeRect toRect() {
        return HomeRect.newBuilder().setX(x).setY(y).setW(w).setH(h).buildPartial();
    }

    public void foreach(BiConsumer<Integer, Integer> consumer) {
        for (int i = x; i <= x1; i++) {
            for (int j = y; j <= y1; j++) {
                consumer.accept(i, j);
            }
        }
    }

}
