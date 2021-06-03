package game.config.param;

import game.config.DataConfigData;

import java.util.concurrent.TimeUnit;

/**
 * @author Yunzhe.Jin
 * 2021/5/13 15:51
 */
public class ParamConfigData {

    /**
     * 初始体力
     */
    public int initPower;

    /**
     * 恢复1点体力需要点秒数
     */
    public int recoverPowerPeriod;

    /**
     * 初始背包容量
     */
    public int bagCapacity;

    /**
     * 初始银行容量
     */
    public int bankCapacity;

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

    /**
     * 恢复满体力需要的雷石数量
     */
    public int powerRecoverFullGem;

    /**
     * 恢复一点体力需要的雷石
     */
    public int powerRecoverGem;

    /**
     * 恢复一点体力需要的金币
     */
    public int powerRecoverGold;


    public void Init(final DataConfigData d) {
        final int count = d.count;
        switch (d.id) {
            case 1:
                initPower = count;
                break;
            case 2:
                recoverPowerPeriod = count;
                break;
            case 3:
                bagCapacity = count;
                break;
            case 4:
                bankCapacity = count;
                break;
            case 5:
                fishPower = count;
                break;
            case 6:
                fishSuccessTime = count;
                break;
            case 7:
                hotelCdTime = (int) TimeUnit.SECONDS.toMillis(count);
                break;
            case 8:
                powerRecoverFullGem = count;
                break;
            case 9:
                powerRecoverGem = count;
                break;
            case 10:
                powerRecoverGold = count;
                break;
        }
    }
}
