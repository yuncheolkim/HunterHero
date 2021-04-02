package game.manager;

import game.base.*;

import java.util.ArrayList;
import java.util.List;
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

    private Work[] dataPersistenceWork = new SingleWork[GameConstants.CORE_PROCESS_COUNT * 3];

    private Work loginWork = new Work(Executors.newFixedThreadPool(GameConstants.CORE_PROCESS_COUNT * 2));

    private List<Work> allWorks = new ArrayList<>();

    private Work[] sceneWork = new SingleWork[GameConstants.CORE_PROCESS_COUNT];

    private LongIdGenerator workIdGen = new DefaultLongIdGenerator();

    public WorkManager() {
        initSingleWork(playerWork);
        initSingleWork(heroCalcWork);
        initSingleWork(dataPersistenceWork);
        initSingleWork(sceneWork);

        addAllWork(loginWork);
    }

    private void addAllWork(Work work) {
        allWorks.add(work);
    }

    private void initSingleWork(Work[] w) {
        for (int i = 0; i < w.length; i++) {
            w[i] = new SingleWork();
            addAllWork(w[i]);
        }
    }

    private void initWork(Work[] w, ExecutorService e) {
        for (int i = 0; i < w.length; i++) {
            w[i] = new Work(e);
            addAllWork(w[i]);
        }
    }

    public Work getPlayerWork(long pid) {
        int index = (int) (pid % playerWork.length);
        return playerWork[index];
    }

    public Work getSceneWork() {
        return sceneWork[(int) (workIdGen.next() % playerWork.length)];
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
        for (Work allWork : allWorks) {
            allWork.start();
        }

        super.start();
    }

    @Override
    public void stop() {
        super.stop();
        for (Work allWork : allWorks) {
            allWork.stop();
        }
    }
}
