package game.module.event.handler;

import game.module.event.IEvent;
import game.module.event.IPlayerEventHandler;
import game.player.Player;

/**
 * @author Yunzhe.Jin
 * 2021/3/7 15:52
 */
public class ResourceAddEventHandler implements IPlayerEventHandler {
    @Override
    public void handler(Player player, IEvent data) {
        ResourceAddEvent e = (ResourceAddEvent) data;

    }
}
