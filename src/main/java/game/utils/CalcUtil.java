package game.utils;

import game.base.IWeight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 计算数值
 *
 * @author Yunzhe.Jin
 * 2021/1/8 17:24
 */
public class CalcUtil {
    public final static ThreadLocalRandom DEFAULT_RANDOM = ThreadLocalRandom.current();

    /**
     * 随机
     *
     * @param min 包含
     * @param max 包含
     * @return
     */
    public static int random(int min, int max) {
        return DEFAULT_RANDOM.nextInt(max - min + 1) + min;
    }


    /**
     * 计算比例
     *
     * @param val  计算值
     * @param rate 比例
     * @return 最终算好的值
     */
    public static int calcRateFinal(int val, int rate) {

        if (rate <= 0) {
            return val;
        }
        float f = rate / 100.0f + 1;
        return (int) (val * f);
    }

    /**
     * @param val
     * @param rate
     * @return 比例增值
     */
    public static int calcRateAdd(int val, int rate) {
        if (rate <= 0) {
            return 0;
        }
        return (int) (val * rate / 100.0f);
    }

    /**
     * @param val
     * @param rate
     * @return 比例增值
     */
    public static int calcRateAdd10000(int val, int rate) {
        return (int) (val * rate / 10000.0f);
    }

    /**
     * 减少比例
     *
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
     * 万分比
     *
     * @param rate
     * @return
     */
    public static boolean happened10000(int rate) {
        return DEFAULT_RANDOM.nextInt(10000) < rate;
    }

    /**
     * 计算属性
     * 返回百分比
     *
     * @param v
     * @param base
     * @return 万分比 int
     */
    public static int calcRateProperty(int v, int base) {
        return (int) (v * 10000.0 / (v + base));
    }

    /**
     * 根据权重随机元素
     *
     * @param weightList
     * @param weightAll
     * @return
     */
    public static <T extends IWeight> T weightRandom(List<T> weightList, int weightAll) {

        int i = DEFAULT_RANDOM.nextInt(weightAll) + 1;
        int sum = 0;
        for (IWeight iWeight : weightList) {

            sum += iWeight.weight();
            if (sum >= i) {
                return (T) iWeight;
            }
        }

        return null;
    }

    /**
     * 根据权重随机元素
     *
     * @param weightList
     * @return
     */
    public static <T extends IWeight> T weightRandom(List<T> weightList) {
        int sum = 0;
        for (IWeight iWeight : weightList) {
            sum += iWeight.weight();
        }
        return weightRandom(weightList, sum);
    }


    public static int getPosInt(int i, int index) {

        char[] chars = String.valueOf(i).toCharArray();
        return chars[index] - '0';
    }

    public static List<Integer> getIntList(int i) {

        char[] chars = String.valueOf(i).toCharArray();
        List<Integer> l = new ArrayList<>(chars.length);

        for (char aChar : chars) {
            l.add(aChar - '0');
        }

        return l;
    }

    /**
     * @param number
     * @param index
     * @param v
     * @return
     */
    public static int putPosInt(int number, int index, int v) {

        char[] chars = String.valueOf(number).toCharArray();
        chars[index] = (char) ('0' + v);
        return Integer.parseInt(String.valueOf(chars));
    }

}
