package game.base.constants;

import game.base.DefaultLongIdGenerator;
import game.base.LongIdGenerator;
import io.netty.util.AttributeKey;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 14:21
 */
public class GameConstants {

    public static final LongIdGenerator TEMP_ID_GENERATOR = new DefaultLongIdGenerator();

    public static final String TOKEN_START = ">>>>>>>>>>>>>>>>>>>>";

    public static final String TOKEN_END = "<<<<<<<<<<<<<<<<<<<<";

    public static final int CORE_PROCESS_COUNT = Runtime.getRuntime().availableProcessors();

    public static final AttributeKey<Long> pid = AttributeKey.newInstance("pid");

    public static final int MAX_PLAYER_LEVEL = 60;

    /**
     * θε
     */
    public static final int ITEM_BAG = 1;

    /**
     * ιΆθ‘
     */
    public static final int ITEM_BANK = 2;
}
