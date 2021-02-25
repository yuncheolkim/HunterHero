package game.manager;

import game.module.event.EventType;
import game.module.event.IEvent;
import game.module.event.IPlayerEventHandler;
import game.player.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yunzhe.Jin
 * 2021/2/25 10:56
 */
public class EventManager {
    /**
     * 玩家事件，只在玩家线程处理
     */
    private Map<EventType, IPlayerEventHandler> playerEventMap = new HashMap<>();

    public EventManager() {
        // 杀敌事件
        playerEventMap.put(EventType.KILL, (player, data) -> {

        });
    }

    public void firePlayerEvent(Player player, IEvent event) {
        playerEventMap.get(event.type()).handler(player, event);
    }
}
