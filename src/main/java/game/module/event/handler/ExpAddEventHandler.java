package game.module.event.handler;

import game.module.event.IPlayerEventHandler;
import game.module.player.Player;
import game.proto.ExpChangePush;
import game.proto.no.No;

/**
 * 玩家或者英雄增加经验
 * heroId == 0 玩家
 * heroId != 0 玩家
 *
 * @author Yunzhe.Jin
 * 2021/3/11 17:45
 */
public class ExpAddEventHandler implements IPlayerEventHandler<ExpAddEvent> {
    @Override
    public void handler(Player player, ExpAddEvent data) {

        // Push
        player.getTransport().send(No.ExpChangePush, ExpChangePush.newBuilder()
                .setHeroId(data.heroId)
                .setAddExp(data.addExp)
                .setCurExp(data.curExp)
                .build());
    }
}
