package game.module.player;

import com.google.protobuf.MessageLite;
import game.base.Logs;
import game.player.Player;
import game.proto.Empty;
import game.proto.PlayerCreateNameReq;
import game.proto.Success;
import org.joda.time.LocalDateTime;
import org.joda.time.Seconds;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 16:00
 */
public class PlayerHandler {

    /**
     * 起名
     * @param player
     * @param o
     * @return
     */
    public static MessageLite createName(Player player, PlayerCreateNameReq o) {

        player.getPd().setName(o.getName());
        return Success.getDefaultInstance();
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 玩家定时器
     * @param player
     * @param o
     * @return
     */
    public static MessageLite tick(Player player, Empty o) {
        Logs.C.info("定时器:{}", player.getPid());

        // 体力恢复
        recoverPower(player);

        checkFight(player);

        return null;
    }

    /**
     * 检查战斗
     * @param player
     */
    private static void checkFight(Player player) {


    }

    /**
     * 恢复体力
     */
    public static void recoverPower(Player player) {

        LocalDateTime now = LocalDateTime.now();
        Seconds seconds = Seconds.secondsBetween(player.getPowerRecoverTime(), now);
        int powerRecoverSecond = player.getPd().getResourceBuilder().getPowerRecoverSecond();
        if (seconds.getSeconds() >= powerRecoverSecond) {
            int recover = seconds.getSeconds() % powerRecoverSecond;
            int power = player.getPd().getResourceBuilder().getPower();
            if (power > player.getPd().getResourceBuilder().getMaxPower()) {
                power = player.getPd().getResourceBuilder().getMaxPower();
            }
            player.getPd().getResourceBuilder().setPower(power);
            player.setPowerRecoverTime(player.getPowerRecoverTime().plusSeconds(recover * powerRecoverSecond));
        }
    }


    /**
     * 定时存db
     * @param player
     * @param o
     * @return
     */
    public static MessageLite dataFlush(Player player, Empty o) {
        Logs.C.info("保存玩家数据:{}", player.getPid());
        player.saveData();

        return null;
    }
}
