package game.manager;

import game.base.G;
import game.base.Logs;
import game.base.Work;
import game.module.event.EventType;
import game.module.event.IEvent;
import game.module.event.IPlayerEventHandler;
import game.module.event.handler.*;
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
    private Map<EventType, IPlayerEventHandler<? extends IEvent>> playerEventMap = new HashMap<>();

    public EventManager() {
        // 杀敌事件
        playerEventMap.put(EventType.KILL, new KillEventHandler());
        // 增加资源
        playerEventMap.put(EventType.RESOURCE_ADD, new ResourceAddEventHandler());
        // 升级
        playerEventMap.put(EventType.LEVEL_UP, new LevelUpEventHandler());
        // 英雄提升
        playerEventMap.put(EventType.HERO_POWER_UP, new HeroPowerUpEventHandler());
        // 消耗金币
        playerEventMap.put(EventType.CONSUME_GOLD, new ConsumeGoldEventHandler());
    }

    /**
     * 玩家线程
     *
     * @param player
     * @param event
     */
    public <T extends IEvent> void firePlayerEvent(Player player, T event) {
        IPlayerEventHandler<T> iPlayerEventHandler = (IPlayerEventHandler<T>) playerEventMap.get(event.type());
        try {
            iPlayerEventHandler.handler(player, event);
        } catch (Exception e) {
            Logs.C.error("", e);
        }
    }

    public <T extends IEvent> void firePlayerEvent(long pid, T event) {
        IPlayerEventHandler<T> iPlayerEventHandler = (IPlayerEventHandler<T>) playerEventMap.get(event.type());
        Optional<Player> f = G.P.findPlayer(pid);
        if (f.isPresent()) {
            Work playerWork = G.W.getPlayerWork(pid);
            Player player = f.get();
            playerWork.addTask(() -> {
                try {
                    iPlayerEventHandler.handler(player, event);
                } catch (Exception e) {
                    Logs.C.error("", e);
                }
            });
        }
    }
}
