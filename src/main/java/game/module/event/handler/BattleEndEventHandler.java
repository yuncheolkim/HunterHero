package game.module.event.handler;

import game.module.event.IPlayerEventHandler;
import game.module.player.Player;
import game.proto.BattleEndPush;
import game.proto.no.No;

/**
 * @author Yunzhe.Jin
 * 2021/7/11 17:45
 */
public class BattleEndEventHandler implements IPlayerEventHandler<BattleEndEvent> {


    @Override
    public void handler(Player player, BattleEndEvent data) {

        player.send(No.BattleEndPush,
                BattleEndPush.newBuilder().setWin(data.success).setBattleId(data.battleId).buildPartial());

    }
}
