package game.utils;

/**
 * @author Yunzhe.Jin
 * 2021/6/23 22:54
 */
public class BitUtils {


    public static boolean isSet(int i, int mask) {
        return (i & mask) != 0;
    }

    public static int set(int i, int mask) {
        return i | mask;
    }

    public static int clean(int i, int mask) {
        return (i | mask) ^ mask;
    }
}
