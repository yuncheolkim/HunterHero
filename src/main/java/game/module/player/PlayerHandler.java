package game.module.player;

import com.google.protobuf.MessageLite;
import game.base.Logs;
import game.player.Player;
import game.proto.Empty;
import game.proto.PlayerCreateNameReq;
import game.proto.Success;

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

        player.getPlayerData().name = o.getName();

        return Success.getDefaultInstance();
    }


    /**
     * 玩家定时器
     * @param player
     * @param o
     * @return
     */
    public static MessageLite tick(Player player, Empty o) {
        Logs.C.info("定时器:{}", player.getPid());

        return null;
    }

    public static MessageLite dataFlush(Player player, Empty o) {
        Logs.C.info("保存玩家数据:{}", player.getPid());
        player.saveData();

        return null;
    }
}
