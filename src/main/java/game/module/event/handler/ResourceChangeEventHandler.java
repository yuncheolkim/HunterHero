package game.module.event.handler;

import game.module.event.IPlayerEventHandler;
import game.module.player.Player;
import game.proto.ResourceChangePush;
import game.proto.no.No;

/**
 * 资源变化后统一处理
 * 推送前端
 *
 * @author Yunzhe.Jin
 * 2021/3/7 15:52
 */
public class ResourceChangeEventHandler implements IPlayerEventHandler<ResourceChangeEvent> {

    @Override
    public void handler(final Player player, final ResourceChangeEvent data) {

        final ResourceChangePush push = ResourceChangePush.newBuilder()
                .setCount(data.count)
                .setCurCount(data.curCount)
                .setHeroId(data.heroId)
                .setResourceId(data.resource.id).build();

        player.getTransport().send(No.ResourceChangePush, push);
    }
}
