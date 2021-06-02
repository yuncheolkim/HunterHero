package game.manager;

import game.base.G;
import game.base.Logs;
import game.base.Work;
import game.module.event.EventType;
import game.module.event.IEvent;
import game.module.event.IPlayerEventHandler;
import game.module.event.handler.*;
import game.player.Player;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 事件集中管理注册
 * 玩家事件，只在玩家线程处理
 *
 * @author Yunzhe.Jin
 * 2021/2/25 10:56
 */
public class EventManager {
    private static final Map<EventType, IPlayerEventHandler<? extends IEvent>> playerEventMap = new HashMap<>();

    public EventManager() {
        // 杀敌事件
        addEvent(new KillEventHandler());
        // 资源变化
        addEvent(new ResourceChangeEventHandler());
        // 升级
        addEvent(new LevelUpEventHandler());
        // 英雄提升
        addEvent(new HeroPowerUpEventHandler());
        // 增加经验
        addEvent(new ExpAddEventHandler());
        // 增加物品
        addEvent(new ItemAddEventHandler());
        // 增加英雄
        addEvent(new HeroAddEventHandler());
    }

    /**
     * @param handler 必须要有默认构造函数
     */
    private void addEvent(IPlayerEventHandler<? extends IEvent> handler) {

        try {
            for (Method declaredMethod : handler.getClass().getMethods()) {
                if (declaredMethod.getName().equals("handler") && !declaredMethod.isBridge()) {
                    Class<?> idClazz = declaredMethod.getParameterTypes()[1];
                    IEvent o = (IEvent) idClazz.newInstance();
                    playerEventMap.put(o.type(), handler);
                }
            }
        } catch (Exception e) {
            G.findException(e);
        }
    }

    /**
     * 玩家线程
     *
     * @param player
     * @param event
     */
    public static <T extends IEvent> void firePlayerEvent(Player player, T event) {
        IPlayerEventHandler<T> iPlayerEventHandler = (IPlayerEventHandler<T>) playerEventMap.get(event.type());
        try {
            iPlayerEventHandler.handler(player, event);
        } catch (Exception e) {
            Logs.C.error(e);
        }
    }

    public static <T extends IEvent> void firePlayerEvent(long pid, T event) {
        IPlayerEventHandler<T> iPlayerEventHandler = (IPlayerEventHandler<T>) playerEventMap.get(event.type());
        Optional<Player> f = G.P.findPlayer(pid);
        if (f.isPresent()) {
            Work playerWork = G.W.getPlayerWork(pid);
            Player player = f.get();
            playerWork.addTask(() -> {
                try {
                    iPlayerEventHandler.handler(player, event);
                } catch (Exception e) {
                    Logs.C.error(e);
                }
            });
        }
    }
}
