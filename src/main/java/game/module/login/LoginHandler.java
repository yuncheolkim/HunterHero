package game.module.login;

import game.base.G;
import game.base.Logs;
import game.player.Player;
import game.proto.LoginReq;
import game.repo.PlayerRepo;
import io.netty.channel.Channel;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 14:14
 */
public class LoginHandler {
    /**
     * 登录
     *
     * @param ch
     * @param request
     */
    public void login(Channel ch, LoginReq request) {
        long playerId = request.getPlayerId();
        PlayerRepo playerRepo = G.R.getPlayerRepo();

        Logs.C.info("start login:{} ---->{}", ch, playerId);
        G.P.compute(playerId, (pid, player) -> {
            if (player == null) {
                player = new Player(pid);
                player.setChannel(ch);
                player.load(request.getCode());
                player.login();
            } else {
                // 踢出之前的登录
                player.kick();
                player.setChannel(ch);
                G.sendToPlayer(pid, -2);
            }
            return player;
        });
    }

    /**
     * 重新登录
     * 需要在用户现场进行一些操作
     */
    public void relogin(Player player) {
        player.relogin();
    }
}
