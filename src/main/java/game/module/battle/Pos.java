package game.module.battle;

/**
 * 位置信息
 *
 * @author Yunzhe.Jin
 * 2021/1/8 15:26
 */
public class Pos {


    private int index;

    /**
     * 位置数量
     */
    private int posCount;

    public static Pos from(int index) {
        Pos p = new Pos();
        p.index = index;
        return p;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPosCount() {
        return posCount;
    }

    public void setPosCount(int posCount) {
        this.posCount = posCount;
    }

    @Override
    public String toString() {
        return "Pos{" +
                "index=" + index +
                '}';
    }
}
