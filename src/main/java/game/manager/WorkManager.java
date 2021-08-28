package game.manager;

import game.base.*;
import game.base.constants.GameConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 工作线程管理
 *
 * @author Yunzhe.Jin
 * 2021/2/20 10:29
 */
public class WorkManager extends AbsLifecycle {

    private final Work[] playerWork = new SingleWork[GameConstants.CORE_PROCESS_COUNT];
    private final Work[] heroCalcWork = new SingleWork[GameConstants.CORE_PROCESS_COUNT];
    private final Work[] sceneWork = new SingleWork[GameConstants.CORE_PROCESS_COUNT];
    private final Work loginWork = new Work(Executors.newFixedThreadPool(GameConstants.CORE_PROCESS_COUNT * 2));
    private final Work[] dataPersistenceWork = new SingleWork[GameConstants.CORE_PROCESS_COUNT * 3];
    private final Work matchWork = new SingleWork();
    private final List<Work> allWorks = new ArrayList<>();
    private final LongIdGenerator workIdGen = new DefaultLongIdGenerator();

    /**
     * 匹配排位定时器
     */
    private ScheduledExecutorService matchSchedule = Executors.newSingleThreadScheduledExecutor();
    private ScheduledExecutorService defaultSchedule = Executors.newScheduledThreadPool(GameConstants.CORE_PROCESS_COUNT);

    public WorkManager() {
        initSingleWorks(playerWork);
        initSingleWorks(heroCalcWork);
        initSingleWorks(dataPersistenceWork);
        initSingleWorks(sceneWork);

        addAllWork(loginWork);
        addAllWork(matchWork);
    }

    private void addAllWork(final Work work) {
        allWorks.add(work);
    }

    private void initSingleWorks(final Work[] w) {
        for (int i = 0; i < w.length; i++) {
            w[i] = new SingleWork();
            addAllWork(w[i]);
        }
    }

    private void initWork(final Work[] w, final ExecutorService e) {
        for (int i = 0; i < w.length; i++) {
            w[i] = new Work(e);
            addAllWork(w[i]);
        }
    }

    public Work getPlayerWork(final long pid) {
        final int index = (int) (pid % playerWork.length);
        return playerWork[index];
    }

    public Work getSceneWork() {
        return sceneWork[(int) (workIdGen.next() % playerWork.length)];
    }


    /**
     * 英雄属性计算线程
     */
    public Work getHeroCalcWork(final long id) {
        return heroCalcWork[(int) (id % heroCalcWork.length)];
    }


    public Work getDataPersistenceWork(final long pid) {
        final int index = (int) (pid % dataPersistenceWork.length);
        return dataPersistenceWork[index];
    }

    public Work getLoginWork() {
        return loginWork;
    }


    @Override
    public void start() {
        for (final Work allWork : allWorks) {
            allWork.start();
        }


        super.start();
    }

    @Override
    public void stop() {
        super.stop();
        for (final Work allWork : allWorks) {
            allWork.stop();
        }
        matchSchedule.shutdownNow();
        try {
            matchSchedule.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Work getMatchWork() {
        return matchWork;
    }

    public ScheduledExecutorService getMatchSchedule() {
        return matchSchedule;
    }

    public ScheduledExecutorService getDefaultSchedule() {
        return defaultSchedule;
    }
}
