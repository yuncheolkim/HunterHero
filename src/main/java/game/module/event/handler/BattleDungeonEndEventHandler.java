package game.module.event.handler;

import game.base.Logs;
import game.module.event.IPlayerEventHandler;
import game.module.player.Player;

/**
 * 更新地下城信息
 *
 * @author Yunzhe.Jin
 * 2021/7/11 17:45
 */
public class BattleDungeonEndEventHandler implements IPlayerEventHandler<BattleEndEvent> {


    @Override
    public void handler(Player player, BattleEndEvent data) {

        Logs.trace(this.getClass().getName());
        if (data.success && player.pd.hasDungeon()) {
            player.pd.getDungeonBuilder().addDefeated(player.pd.getDungeonBuilder().getBossId());
        }
    }
}
