package game.module.battle;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Yunzhe.Jin
 * 2021/1/8 16:52
 */
public class BattleConstant {


    public static final AtomicLong ID_GEN = new AtomicLong();

    /**
     * 没有cd
     */
    public static final CoolDown INFINITE = new CoolDown();

    /**
     * buff
     */
    public static final int BUFF_INFINITE = 0;

    public static final int buff_guanyu_1 = 2;

    public static final int buff_zhaoyun_1 = 6;

    public static final int buff_machao_1 = 7;

    public static final int buff_lusu_1 = 1;
    public static final int buff_zhuoshao = 2;

}
