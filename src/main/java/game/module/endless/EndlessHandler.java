package game.module.endless;

import game.anno.GameHandler;
import game.module.fight.FightService;
import game.player.Player;
import game.proto.EndlessStartReq;
import game.proto.no.No;

/**
 * 无尽模式
 *
 * @author Yunzhe.Jin
 * 2021/9/17 21:39
 */
public class EndlessHandler {


    @GameHandler(value = No.EndlessStartReq, desc = "开始无尽模式挑战")
    public static void start(Player player, EndlessStartReq req) {

        FightService.startEndless(player, req.getLayer(), req.getBattleId());
    }
}
