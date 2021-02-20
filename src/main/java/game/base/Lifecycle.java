package game.base;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 10:40
 */
public interface Lifecycle {
    void start();

    void stop();

    boolean isRunning();
}
