package game.module.battle;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Yunzhe.Jin
 * 2021/1/8 16:52
 */
public class Constant {


    public static final AtomicLong ID_GEN = new AtomicLong();

    /**
     * 没有cd
     */
    public static final CoolDown INFINITE = new CoolDown();

    /**
     * buff
     */
    public static final int BUFF_INFINITE = -8;

}
