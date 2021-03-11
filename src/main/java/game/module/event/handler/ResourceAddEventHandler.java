package game.module.event.handler;

import game.module.event.IPlayerEventHandler;
import game.player.Player;
import game.proto.ResourceChangePush;
import game.proto.back.MsgNo;

/**
 * 资源变化后统一处理
 * 推送前端
 *
 * @author Yunzhe.Jin
 * 2021/3/7 15:52
 */
public class ResourceAddEventHandler implements IPlayerEventHandler<ResourceAddEvent> {

    @Override
    public void handler(Player player, ResourceAddEvent data) {

        ResourceChangePush push = ResourceChangePush.newBuilder()
                .setCount(data.count)
                .setHeroId(data.heroId)
                .setResourceId(data.resource.id).build();

        player.getTransport().send(MsgNo.resource_change_push_VALUE, push);
    }
}
