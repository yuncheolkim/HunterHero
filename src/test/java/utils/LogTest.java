package utils;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import game.base.DefaultLog;
import org.junit.Test;

/**
 * @author Yunzhe.Jin
 * 2021/3/9 19:36
 */
public class LogTest {
    @Test
    public void test1() {
        Log l = new DefaultLog("abc");

        l.info("okc:{}", "123");
        l.info(new NullPointerException());
        l.info(new NullPointerException(), "okc:{}", "123");
    }

    @Test
    public void t2() {
        System.out.println(-8 % 4);
        System.out.println(-4 % 4);
    }
}


class Loggerwrap {
    private static final String FQCN = Loggerwrap.class.getName();

    Log log = LogFactory.get("ok");

    public void info(String s) {
        log.info(FQCN, null, s, "");
    }
}
