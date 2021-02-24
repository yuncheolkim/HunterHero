package game.base;

import io.netty.util.AttributeKey;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 14:21
 */
public class Constants {
    public static final String TOKEN_START = ">>>>>>>>>>>>>>>>>>>>";

    public static final String TOKEN_END = "<<<<<<<<<<<<<<<<<<<<";

    public static final int CORE_PROCESS_COUNT = Runtime.getRuntime().availableProcessors();

    public static final AttributeKey<Long> pid = AttributeKey.newInstance("pid");

}
