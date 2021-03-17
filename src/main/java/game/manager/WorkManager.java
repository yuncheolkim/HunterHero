package game.manager;

import game.base.AbsLifecycle;
import game.base.GameConstants;
import game.base.SingleWork;
import game.base.Work;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 工作线程管理
 *
 * @author Yunzhe.Jin
 * 2021/2/20 10:29
 */
public class WorkManager extends AbsLifecycle {

    private Work[] playerWork = new SingleWork[GameConstants.CORE_PROCESS_COUNT];

    private Work[] heroCalcWork = new SingleWork[GameConstants.CORE_PROCESS_COUNT];

    private Work[] dataPersistenceWork = new Work[GameConstants.CORE_PROCESS_COUNT * 3];

    private Work loginWork = new Work(Executors.newFixedThreadPool(GameConstants.CORE_PROCESS_COUNT * 2));

    public WorkManager() {
        initSingleWork(playerWork);
        initSingleWork(heroCalcWork);
        initWork(dataPersistenceWork, Executors.newSingleThreadExecutor());
    }

    private void initSingleWork(Work[] w) {
        for (int i = 0; i < w.length; i++) {
            w[i] = new SingleWork();
        }
    }

    private void initWork(Work[] w, ExecutorService e) {
        for (int i = 0; i < w.length; i++) {
            w[i] = new Work(e);
        }
    }

    public Work getPlayerWork(long pid) {
        int index = (int) (pid % playerWork.length);
        return playerWork[index];
    }


    /**
     * 英雄属性计算线程
     *
     * @param pid
     * @return
     */
    public Work getHeroCalcWork(long pid) {
        return heroCalcWork[(int) (pid % heroCalcWork.length)];
    }


    public Work getDataPersistenceWork(long pid) {
        int index = (int) (pid % dataPersistenceWork.length);
        return dataPersistenceWork[index];
    }

    public Work getLoginWork() {
        return loginWork;
    }


    @Override
    public void start() {
        for (Work work : playerWork) {
            work.start();
        }
        for (Work work : dataPersistenceWork) {
            work.start();
        }
        for (Work work : heroCalcWork) {
            work.start();
        }
        loginWork.start();
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
        for (Work work : playerWork) {
            work.stop();
        }
        for (Work work : dataPersistenceWork) {
            work.stop();
        }
        for (Work work : heroCalcWork) {
            work.stop();
        }
        loginWork.stop();
    }
}
