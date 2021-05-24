package utils;

import com.google.common.base.Stopwatch;
import game.utils.CalcUtil;
import org.junit.Test;

/**
 * @author Yunzhe.Jin
 * 2021/3/2 22:35
 */
public class CalcUtilTest {

    @Test
    public void testcalcRateProperty() {

        System.out.println(CalcUtil.calcRateProperty(100, 200));

    }

    @Test
    public void testGetPosInt() {
        measureTime(() -> {
            for (int i = 0; i < 1000000; i++) {
                CalcUtil.getPosInt(123456789, i % 9);
            }
        });


        System.out.println(CalcUtil.getPosInt(123456789, 0));
        System.out.println(CalcUtil.getPosInt(123456789, 1));
    }

    volatile int j;

    @Test
    public void testGetPosInt1() {

        System.out.println(CalcUtil.getPosInt(123456789, 0));
        System.out.println(CalcUtil.getPosInt(123456789, 1));
        System.out.println(CalcUtil.getPosInt(123456789, 2));
        System.out.println(CalcUtil.getPosInt(123456789, 3));
        System.out.println(CalcUtil.getPosInt(123456789, 4));
        System.out.println(CalcUtil.getPosInt(123456789, 5));
        System.out.println(CalcUtil.getPosInt(123456789, 6));
        System.out.println(CalcUtil.getPosInt(123456789, 7));
        System.out.println(CalcUtil.getPosInt(123456789, 8));

    }

    //
    @Test
    public void testPutPosInt() {
        measureTime(() -> {
            for (int i = 0; i < 1000000; i++) {
                CalcUtil.putPosInt(123456789, i % 9, 8);
            }
        });


        System.out.println(CalcUtil.putPosInt(123456789, 0, 8));
    }

    @Test
    public void testPutPosInt1() {

        System.out.println(CalcUtil.putPosInt(12345, 0, 8));
        System.out.println(CalcUtil.putPosInt(12345, 1, 5));
        System.out.println(CalcUtil.putPosInt(123450, 2, 5));
        System.out.println(CalcUtil.putPosInt(123450, 3, 5));
        System.out.println(CalcUtil.putPosInt(123450, 4, 5));

    }

    public static void measureTime(Runnable runnable) {
        Stopwatch stopwatch = Stopwatch.createStarted();

        runnable.run();

        System.out.println(stopwatch.stop());
    }
}
