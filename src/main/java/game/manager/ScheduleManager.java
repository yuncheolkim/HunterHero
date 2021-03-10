package game.manager;

import game.base.AbsLifecycle;
import game.base.G;
import game.base.Work;
import game.msg.MsgProcess;
import game.msg.MsgUtil;
import game.player.Player;
import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 游戏定时器管理
 *
 * @author Yunzhe.Jin
 * 2021/2/23 16:21
 */
public class ScheduleManager extends AbsLifecycle {
    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor(new DefaultThreadFactory("玩家定时器"));

    /**
     * 玩家定时器
     */
    public void doPlayerTick() {

        for (Map.Entry<Long, Player> player : G.P.allPlayer()) {
            Work playerWork = G.W.getPlayerWork(player.getKey());

            playerWork.addTask(new MsgProcess(MsgUtil.playerTick, player.getValue()));
        }
        executorService.schedule(this::doPlayerTick, 5, TimeUnit.SECONDS);
    }

    /**
     * 保存玩家数据
     */
    public void dataFlushSchedule() {

        for (Map.Entry<Long, Player> player : G.P.allPlayer()) {
            Work playerWork = G.W.getPlayerWork(player.getKey());

            playerWork.addTask(new MsgProcess(MsgUtil.dataFlushTick, player.getValue()));
        }
        executorService.schedule(this::dataFlushSchedule, 30, TimeUnit.SECONDS);
    }

    public void start() {
        super.start();
        executorService.schedule(this::doPlayerTick, 0, TimeUnit.SECONDS);
        executorService.schedule(this::dataFlushSchedule, 0, TimeUnit.SECONDS);
    }
}
