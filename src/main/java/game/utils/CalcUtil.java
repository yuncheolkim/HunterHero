package game.utils;

import game.base.IWeight;

import java.util.List;
import java.util.Random;

/**
 * 计算数值
 * @author Yunzhe.Jin
 * 2021/1/8 17:24
 */
public class CalcUtil {
    public final static Random DEFAULT_RANDOM = new Random();

    /**
     * 随机
     * @param min 包含
     * @param max 包含
     * @return
     */
    public static int random(int min, int max) {
        return DEFAULT_RANDOM.nextInt(max - min + 1) + min;
    }


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

    public static int calcRateSub(int val, float rate) {
        return (int) (val * (1 - rate));
    }

    public static int calcRateAdd(int val, float rate) {
        return (int) (val * rate);
    }

    public static boolean happened(Random r, int rate, int total) {
        return rate + 1 > r.nextInt(total);
    }

    /**
     * 计算属性
     * 返回百分比
     * @param v
     * @param base
     * @return 万分比 int
     */
    public static int calcRateProperty(int v, int base) {
        return (int) (v * 10000.0 / (v + base));
    }

    /**
     * 根据权重随机元素
     * @param weightList
     * @param weightAll
     * @return
     */
    public static IWeight weightRandom(List<? extends IWeight> weightList, int weightAll) {

        int i = DEFAULT_RANDOM.nextInt(weightAll) + 1;
        int sum = 0;
        for (IWeight iWeight : weightList) {

            sum += iWeight.weight();
            if (sum >= i) {
                return iWeight;
            }
        }

        return null;
    }

    /**
     * 根据权重随机元素
     * @param weightList
     * @return
     */
    public static IWeight weightRandom(List<? extends IWeight> weightList) {
        int sum = 0;
        for (IWeight iWeight : weightList) {
            sum += iWeight.weight();
        }
        return weightRandom(weightList, sum);
    }
}
