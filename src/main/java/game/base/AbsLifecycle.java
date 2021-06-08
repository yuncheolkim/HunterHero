package game.base;

import java.util.concurrent.atomic.AtomicBoolean;

import static game.base.constants.GameConstants.TOKEN_END;
import static game.base.constants.GameConstants.TOKEN_START;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 10:42
 */
public abstract class AbsLifecycle implements Lifecycle {
    protected AtomicBoolean stopped = new AtomicBoolean(true);

    @Override
    public void start() {
        Logs.C.info(TOKEN_START + "start {}", getClass().getSimpleName());
        stopped.set(false);
    }

    @Override
    public void stop() {
        stopped.set(true);
        Logs.C.info(TOKEN_END + "stop {}", getClass().getSimpleName());
    }

    @Override
    public boolean isRunning() {
        return stopped.get();
    }
}
