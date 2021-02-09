package game.hunter;

import java.util.Random;

/**
 * 计算数值
 * @author Yunzhe.Jin
 * 2021/1/8 17:24
 */
public class CalcUtil {

    /**
     * 计算比例
     * @param val  计算值
     * @param rate 比例
     * @return 最终算好的值
     */
    public static int calcRate(int val, int rate) {
        float f = rate / 100.0f + 1;
        return (int) (val * f);
    }

    /**
     * @param val
     * @param rate
     * @return 比例增值
     */
    public static int calcRateAdd(int val, int rate) {
        return (int) (val * rate / 100.0f);
    }

    /**
     * 减少比例
     * @param val
     * @param rate
     * @return
     */
    public static int calcRateSub(int val, int rate) {
        return (int) (val * (100 - rate) / 100.0f);
    }

    public static int calcRateAdd(int val, float rate) {
        return (int) (val * rate);
    }

    public static boolean happened(Random r, int rate, int total) {
        return rate + 1 > r.nextInt(total);
    }
}
