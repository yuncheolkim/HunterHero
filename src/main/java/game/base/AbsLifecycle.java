package game.base;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 10:42
 */
public abstract class AbsLifecycle implements Lifecycle {
    private AtomicBoolean stopped = new AtomicBoolean(true);

    @Override
    public void start() {
        Logs.C.info(">>>>>>>>>>>>>>>>>>>start {}", getClass().getSimpleName());
        stopped.set(false);
    }

    @Override
    public void stop() {
        Logs.C.info("<<<<<<<<<<<<<<<<<<<stop {}", getClass().getSimpleName());
        stopped.set(true);
    }

    @Override
    public boolean isRunning() {
        return stopped.get();
    }
}
