package game.manager;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import com.google.common.reflect.ClassPath;
import game.anno.EventHandler;
import game.base.AbsLifecycle;
import game.base.G;
import game.base.Logs;
import game.base.Work;
import game.module.event.EventType;
import game.module.event.IEvent;
import game.module.event.IPlayerEventHandler;
import game.module.event.handler.*;
import game.player.Player;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Optional;

import static game.utils.AssisUtils.createEvent;

/**
 * 事件集中管理注册
 * 玩家事件，只在玩家线程处理
 *
 * @author Yunzhe.Jin
 * 2021/2/25 10:56
 */
public class EventManager extends AbsLifecycle {
    private static final Multimap<EventType, IPlayerEventHandler<? extends IEvent>> playerEventMap = ArrayListMultimap.create();

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
        // 完成任务
        addEvent(new TaskCompleteEventHandler());
        // 战役相关
        addEvent(new BattleEndEventHandler());
        addEvent(new BattleDungeonEndEventHandler());
    }

    /**
     * @param handler 必须要有默认构造函数
     */
    private void addEvent(final IPlayerEventHandler<? extends IEvent> handler) {

        try {
            for (final Method declaredMethod : handler.getClass().getMethods()) {
                if (declaredMethod.getName().equals("handler") && !declaredMethod.isBridge()) {
                    final Class<?> idClazz = declaredMethod.getParameterTypes()[1];
                    final IEvent o = (IEvent) idClazz.newInstance();
                    playerEventMap.put(o.type(), handler);
                }
            }
        } catch (final Exception e) {
            G.findException(e);
        }
    }

    /**
     * 玩家线程
     *
     * @param player
     * @param event
     */
    public static <T extends IEvent> void firePlayerEvent(final Player player, final T event) {
        final Collection<IPlayerEventHandler<? extends IEvent>> iPlayerEventHandler = playerEventMap.get(event.type());
        for (final IPlayerEventHandler<? extends IEvent> playerEventHandler : iPlayerEventHandler) {
            try {

                ((IPlayerEventHandler<T>) playerEventHandler).handler(player, event);
            } catch (final Exception e) {
                Logs.C.error(e);
            }
        }
    }

    public static <T extends IEvent> void firePlayerEvent(final long pid, final T event) {
        final Collection<IPlayerEventHandler<? extends IEvent>> iPlayerEventHandler = playerEventMap.get(event.type());
        final Optional<Player> f = G.P.findPlayer(pid);
        if (f.isPresent()) {
            final Work playerWork = G.W.getPlayerWork(pid);
            final Player player = f.get();
            playerWork.addTask(() -> {
                for (final IPlayerEventHandler<? extends IEvent> playerEventHandler : iPlayerEventHandler) {
                    try {

                        ((IPlayerEventHandler<T>) playerEventHandler).handler(player, event);
                    } catch (final Exception e) {
                        Logs.C.error(e);
                    }
                }
            });
        }
    }

    @Override
    public void start() {
        super.start();

        try {
            ImmutableSet<ClassPath.ClassInfo> topLevelClasses = ClassPath.from(ClassLoader.getSystemClassLoader()).getTopLevelClassesRecursive("game.module");
            topLevelClasses.stream().filter(classInfo -> {
                return classInfo.getPackageName().startsWith("game.module");
            }).forEach(classInfo -> {

                Class<?> clazz = classInfo.load();
                for (Method m : clazz.getDeclaredMethods()) {
                    if (m.isAnnotationPresent(EventHandler.class)) {
                        Logs.C.info("[Event] ==========> {}:{}", classInfo.getName(), m.getName());

                        try {
                            IPlayerEventHandler event = createEvent(clazz, m);
                            playerEventMap.put(m.getAnnotation(EventHandler.class).value(), event);
                        } catch (Exception e) {
                            Logs.C.error("解析失败:{},{}", clazz.getName(), m.getName());
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
