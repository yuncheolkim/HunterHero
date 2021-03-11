package game.module.event.handler;

import game.module.event.IPlayerEventHandler;
import game.player.Player;
import game.proto.ExpChangePush;
import game.proto.back.MsgNo;

/**
 * @author Yunzhe.Jin
 * 2021/3/11 17:45
 */
public class ExpAddEventHandler implements IPlayerEventHandler<ExpAddEvent> {
    @Override
    public void handler(Player player, ExpAddEvent data) {

        player.getTransport().send(MsgNo.resource_change_push_VALUE, ExpChangePush.newBuilder()
                .setHeroId(data.heroId)
                .setAddExp(data.addExp)
                .setCurExp(data.curExp)
                .build());
    }
}
