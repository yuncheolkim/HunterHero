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


    public static final int buff_guanyu_skill1 = 2;

    public static final int buff_zhaoyun_1 = 6;

}
