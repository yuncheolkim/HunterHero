package game.module.endless;

import game.anno.EventHandler;
import game.anno.GameHandler;
import game.base.Logs;
import game.module.event.EventType;
import game.module.event.handler.BattleEndEvent;
import game.module.fight.FightService;
import game.player.Player;
import game.proto.EndlessStartReq;
import game.proto.data.FightType;
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
        int level = 1;
        if (player.pd.getEndlessLayer() > 1) {
            level = player.pd.getEndlessLayer();
        }
        FightService.startEndless(player, level, req.getBattleId());
    }

    @EventHandler(EventType.BATTLE_END)
    public static void endBattleEventHandler(Player player, BattleEndEvent event) {
        if (event.fightType == FightType.F_ENDLESS) {
            // 无尽战斗结束
            Logs.C.info("Endless battle end");

        }
    }
}
