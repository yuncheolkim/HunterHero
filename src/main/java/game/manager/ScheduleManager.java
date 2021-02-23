package game.manager;

import game.base.AbsLifecycle;
import game.base.G;
import game.base.Work;
import game.msg.MsgProcess;
import game.msg.MsgUtil;
import game.player.Player;
import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Yunzhe.Jin
 * 2021/2/23 16:21
 */
public class ScheduleManager extends AbsLifecycle {
    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor(new DefaultThreadFactory("玩家定时器"));

    public void doWork() {

        Iterator<Map.Entry<Long, Player>> longEnumeration = G.P.allPlayer().iterator();

        while (longEnumeration.hasNext()) {
            Map.Entry<Long, Player> player = longEnumeration.next();
            Work playerWork = G.W.getPlayerWork(player.getKey());

            playerWork.addTask(new MsgProcess(MsgUtil.playerTick, player.getValue()));
        }
        executorService.schedule(this::doWork, 5, TimeUnit.SECONDS);
    }

    public void start() {
        super.start();
        executorService.schedule(this::doWork, 0, TimeUnit.SECONDS);
    }
}
