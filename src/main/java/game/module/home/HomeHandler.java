package game.module.home;

import game.player.Player;
import game.proto.HomeOpenAreaRqRs;

/**
 * 家园系统
 *
 * @author Yunzhe.Jin
 * 2021/4/15 15:27
 */
public class HomeHandler {

    /**
     * 开启区域
     *
     * @param player
     */
    public static HomeOpenAreaRqRs openArea(Player player, HomeOpenAreaRqRs req) {

        return req;
    }

    /**
     * 种植
     *
     * @param player
     */
    public static void farm(Player player) {

    }

    /**
     * 收割
     *
     * @param player
     */
    public static void harvest(Player player) {

    }

    /**
     * 放置建筑物
     *
     * @param player
     */
    public static void build(Player player) {

    }
}
