package game.manager;

import game.base.G;
import game.base.Work;
import game.module.event.EventType;
import game.module.event.IEvent;
import game.module.event.IPlayerEventHandler;
import game.module.event.handler.LevelUpEventHandler;
import game.module.event.handler.ResourceAddEventHandler;
import game.player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
        // 不包括经验
        playerEventMap.put(EventType.RESOURCE_ADD, new ResourceAddEventHandler());
        playerEventMap.put(EventType.LEVEL_UP, new LevelUpEventHandler());
    }

    /**
     * 玩家线程
     *
     * @param player
     * @param event
     */
    public void firePlayerEvent(Player player, IEvent event) {
        IPlayerEventHandler iPlayerEventHandler = playerEventMap.get(event.type());
        iPlayerEventHandler.handler(player, event);
    }

    public void firePlayerEvent(long pid, IEvent event) {
        IPlayerEventHandler iPlayerEventHandler = playerEventMap.get(event.type());
        Optional<Player> f = G.P.findPlayer(pid);
        if (f.isPresent()) {
            Work playerWork = G.W.getPlayerWork(pid);
            Player player = f.get();
            playerWork.addTask(() -> {
                iPlayerEventHandler.handler(player, event);
            });
        }
    }
}
