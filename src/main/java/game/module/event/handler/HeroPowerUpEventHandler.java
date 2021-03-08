package game.module.event.handler;

import game.base.G;
import game.module.event.IPlayerEventHandler;
import game.msg.MsgProcess;
import game.player.Player;
import game.proto.Message;
import game.proto.data.PlayerHero;

/**
 * 英雄属性变化，重新计算属性
 * @author Yunzhe.Jin
 * 2021/3/8 11:21
 */
public class HeroPowerUpEventHandler implements IPlayerEventHandler<HeroPowerUpEvent> {
    @Override
    public void handler(Player player, HeroPowerUpEvent data) {

        final PlayerHero h = player.getPd().getHeroOrThrow(data.heroId);
        long pid = player.getPid();

        G.W.getHeroCalcWork().addTask(() -> {
            // 基础属性
            PlayerHero.Builder property = PlayerHero.newBuilder().mergeFrom(h);
            G.G.getHeroCalcProcess().doProcess(h, property);

            G.W.getPlayerWork(pid).addTask(new MsgProcess(Message.newBuilder()
                    .setMsgNo(12)
                    .setBody(property.build().toByteString()).build(), pid));
        });
    }
}
