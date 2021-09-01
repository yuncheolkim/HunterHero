package game.utils;

/**
 * @author Yunzhe.Jin
 * 2021/9/1 21:14
 */
public class MathUtils {


    public static long clamp(long min, long max, long v) {
        if (v > max) {
            return max;
        }

        if (v < min) {
            return min;
        }
        return v;

    }
}
