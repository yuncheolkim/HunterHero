package utils;

import cn.hutool.core.lang.caller.CallerUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.StaticLog;
import org.junit.Test;

/**
 * @author Yunzhe.Jin
 * 2021/3/9 19:36
 */
public class LogTest {
    @Test
    public void test1() {

        StaticLog.info("test");
        new Loggerwrap().info("good");

    }
}


class Loggerwrap {
    private static final String FQCN = Loggerwrap.class.getName();

    Log log =LogFactory.get(CallerUtil.getCallerCaller());

    public void info(String s) {
        log.info(FQCN,null,s,"");
    }
}
