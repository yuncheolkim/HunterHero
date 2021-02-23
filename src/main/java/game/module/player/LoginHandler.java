package game.module.player;

import game.base.G;
import game.base.Logs;
import game.player.Player;
import game.proto.LoginReq;
import io.netty.channel.Channel;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 14:14
 */
public class LoginHandler {
    /**
     * 登录
     * @param ch
     * @param request
     */
    public void login(Channel ch, LoginReq request) {
        long playerId = request.getPlayerId();
        Logs.C.info("start login:{} ---->{}", ch, playerId);
        G.P.compute(playerId, (pid, player) -> {
            if (player == null) {
                player = new Player(pid);
                player.setChannel(ch);
                player.load(request.getCode());
            } else {
                // 踢出之前的登录
                player.kick();
                player.setChannel(ch);
            }
            player.login();

            player.send(null);

            return player;
        });
    }
}
