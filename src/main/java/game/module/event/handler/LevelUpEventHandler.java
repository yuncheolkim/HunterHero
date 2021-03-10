package game.module.event.handler;

import game.base.G;
import game.module.event.IPlayerEventHandler;
import game.player.Player;
import game.proto.PlayerLevelChangePush;
import game.proto.back.MsgNo;

/**
 * @author Yunzhe.Jin
 * 2021/3/7 16:05
 */
public class LevelUpEventHandler implements IPlayerEventHandler<LevelUpEvent> {
    @Override
    public void handler(Player player, LevelUpEvent data) {

        if (data.heroId > 0) {
            // 英雄战力计算
            G.E.firePlayerEvent(player, new HeroPowerUpEvent(data.heroId));
        } else {
            // push
            player.getTransport().send(MsgNo.PlayerLevelChangePushNo_VALUE, PlayerLevelChangePush.newBuilder().setValue(data.level).build());
        }
    }
}
