package game.base;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Yunzhe.Jin
 * 2021/1/14 15:44
 */
public class Logs {

    public static final Logger C = LoggerFactory.getLogger("C");
    public static final Logger M = LoggerFactory.getLogger("module");

    public static void trace(Object... args) {

        for (Object arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();

    }

}
