package game.base;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author Yunzhe.Jin
 * 2021/3/5 16:04
 */
public class SingleWork extends Work {
    private volatile long threadId;

    public SingleWork() {
        this("factory");
    }

    public SingleWork(String name) {
        ThreadFactory factory = new DefaultThreadFactory(name) {

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = super.newThread(r);
                threadId = thread.getId();

                return thread;
            }
        };

        executor = Executors.newSingleThreadExecutor(factory);
    }

    @Override
    public boolean addTask(Runnable msg) {
        if (Thread.currentThread().getId() == getThreadId()) {
            msg.run();
            return true;
        }
        return super.addTask(msg);
    }

    public long getThreadId() {
        return threadId;
    }
}
