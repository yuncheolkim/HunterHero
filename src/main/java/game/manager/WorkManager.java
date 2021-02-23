package game.manager;

import game.base.AbsLifecycle;
import game.base.Constants;
import game.base.Work;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 10:29
 */
public class WorkManager extends AbsLifecycle {

    private Work[] playerWork = new Work[Constants.CORE_PROCESS_COUNT * 2];

    private Work[] dataPersistenceWork = new Work[Constants.CORE_PROCESS_COUNT * 3];

    private Work loginWork = new Work(Executors.newFixedThreadPool(Constants.CORE_PROCESS_COUNT * 2));

    public WorkManager() {
        initWork(playerWork, Executors.newSingleThreadExecutor());
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
        loginWork.start();
        super.start();
    }
}
