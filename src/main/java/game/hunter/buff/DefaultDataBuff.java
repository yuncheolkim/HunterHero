package game.hunter.buff;

/**
 * @author Yunzhe.Jin
 * 2021/2/3 20:02
 */
public class DefaultDataBuff extends Buff {
    protected DefaultBuffData data = new DefaultBuffData();

    /**
     * 返回buff相关数据
     * @return
     */
    public IBuffVal buffVal() {
        return data;
    }
}
