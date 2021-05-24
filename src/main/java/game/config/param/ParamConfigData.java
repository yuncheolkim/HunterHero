package game.config.param;

import java.util.concurrent.TimeUnit;

/**
 * @author Yunzhe.Jin
 * 2021/5/13 15:51
 */
public class ParamConfigData {
    /**
     * 一次钓鱼消耗的体力
     */
    public int fishPower;

    /**
     * 钓鱼成功毫秒
     */
    public int fishSuccessTime;

    /**
     * 回城cd时间，毫秒
     */
    public int hotelCdTime = (int) TimeUnit.MINUTES.toMillis(5);
}
