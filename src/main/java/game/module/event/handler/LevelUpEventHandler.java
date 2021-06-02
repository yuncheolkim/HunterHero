package game.module.event.handler;

import game.game.ResourceSourceEnum;
import game.manager.ConfigManager;
import game.manager.EventManager;
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
    public void handler(final Player player, final LevelUpEvent data) {

        if (data.heroId > 0) {
            // 英雄战力计算
            EventManager.firePlayerEvent(player, new HeroPowerUpEvent(data.heroId));
        } else {
            // push
            player.getTransport().send(MsgNo.PlayerLevelChangePushNo_VALUE, PlayerLevelChangePush.newBuilder().setValue(data.level).build());

            // 计算体力
            player.setMaxPower(ConfigManager.GetInitPower() + data.level);
            player.resetPower(ResourceSourceEnum.升级);

        }
    }
}
