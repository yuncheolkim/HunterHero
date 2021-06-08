package game.base;


import cn.hutool.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Yunzhe.Jin
 * 2021/1/14 15:44
 */
public class Logs {

    public static final Log C = new DefaultLog("common", "[common]");

    public static final Logger M = LoggerFactory.getLogger("module");

    public static final Logger chat = LoggerFactory.getLogger("chat");

    public static final Logger evil = LoggerFactory.getLogger("evil");

    public static void trace(final Object... args) {

        for (final Object arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();

    }

}
