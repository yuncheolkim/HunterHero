package game.manager;

import game.base.AbsLifecycle;
import game.base.Work;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 10:29
 */
public class WorkManager extends AbsLifecycle {

    private Work[] playerWork = new Work[Runtime.getRuntime().availableProcessors() * 2];

    private Work loginWork = new Work(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 5));

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
