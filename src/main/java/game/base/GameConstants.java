package game.base;

import io.netty.util.AttributeKey;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 14:21
 */
public class GameConstants {

    public static final LongIdGenerator ID_GENERATOR = new DefaultLongIdGenerator();

    public static final String TOKEN_START = ">>>>>>>>>>>>>>>>>>>>";

    public static final String TOKEN_END = "<<<<<<<<<<<<<<<<<<<<";

    public static final int CORE_PROCESS_COUNT = Runtime.getRuntime().availableProcessors();

    public static final AttributeKey<Long> pid = AttributeKey.newInstance("pid");

    public static final int MAX_PLAYER_LEVEL = 60;

    /**
     * 背包
     */
    public static final int ITEM_BAG = 1;

    /**
     * 银行
     */
    public static final int ITEM_BANK = 2;
}
