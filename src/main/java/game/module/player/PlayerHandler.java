package game.module.player;

import game.base.Logs;
import game.game.ResourceSourceEnum;
import game.module.fight.FightService;
import game.player.Player;
import game.proto.*;
import game.proto.back.MsgNo;
import game.proto.data.PlayerHero;
import game.proto.data.Resource;

import java.util.concurrent.TimeUnit;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 16:00
 */
public class PlayerHandler {
    public static void heartbeat(Player player, HeartbeatReq o) {
        player.getTransport().send(MsgNo.heartbeat_VALUE, HeartbeatRes.getDefaultInstance());
    }

    /**
     * 起名
     *
     * @param player
     * @param o
     * @return
     */
    public static void createName(Player player, PlayerCreateNameReq o) {

        player.getPd().setName(o.getName());
        player.getTransport().send(3, Empty.getDefaultInstance());

    }

    /**
     * 更新英雄属性
     *
     * @param player
     * @param hero
     */
    public static void updateHero(Player player, PlayerHero hero) {
        player.getPd().putHero(hero.getId(), hero);
        // Push
        player.getTransport().send(MsgNo.hero_change_VALUE, HeroChangePush.newBuilder().setHero(hero).build());
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 玩家定时器
     * 每5秒执行一次
     *
     * @param player
     * @param o
     * @return
     */
    public static void tick(Player player) {
        Logs.C.info("定时器:{}", player.getPid());

        // 体力恢复
        recoverPower(player);

        // 检查战斗
        FightService.checkFight(player);

    }


    /**
     * 恢复体力
     */
    public static void recoverPower(Player player) {

        long now = System.currentTimeMillis();

        long second = TimeUnit.MILLISECONDS.toSeconds(now - player.D.getPowerRecoverTime());
        Resource.Builder resourceBuilder = player.getPd().getResourceBuilder();
        int powerRecoverSecond = resourceBuilder.getPowerRecoverSecond();
        if (second >= powerRecoverSecond) {
            long recover = second / powerRecoverSecond;
            player.addPower(recover, ResourceSourceEnum.自动恢复);
            player.D.setPowerRecoverTime(player.D.getPowerRecoverTime() + 1000L * recover * powerRecoverSecond);
        }
    }


    /**
     * 定时存db
     *
     * @param player
     * @param o
     * @return
     */
    public static void dataFlush(Player player, Empty o) {
        Logs.C.info("保存玩家数据:{}", player.getPid());
        player.saveData();
    }
}
