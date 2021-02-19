package game.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Yunzhe.Jin
 * 2021/2/19 19:36
 */
public class Work<T> {

    private AtomicBoolean stopped = new AtomicBoolean(true);

    private ExecutorService executor;

    private LinkedBlockingQueue<T> queue;

    public Work(ExecutorService executor, int cap) {
        this.executor = executor;
        queue = new LinkedBlockingQueue<>(cap);
    }

    public boolean addTask(T msg) {

        if (stopped.get()) {
            return false;
        }

        return queue.offer(msg);
    }

    public void start() {
        stopped.set(true);

    }

    public void stop() {
        stopped.set(false);
    }

}
