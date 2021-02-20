package game.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Yunzhe.Jin
 * 2021/2/19 19:36
 */
public class Work extends AbsLifecycle {

    private AtomicBoolean stopped = new AtomicBoolean(true);

    private ExecutorService executor;


    public Work(ExecutorService executor) {
        this.executor = executor;
    }

    public boolean addTask(Runnable msg) {

        if (stopped.get()) {
            return false;
        }
        try {
            executor.execute(msg);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void start() {
        super.start();

    }

    public void stop() {
        super.stop();

        executor.shutdown();
        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
