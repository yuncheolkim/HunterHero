package game.game.scene;

/**
 * @author Yunzhe.Jin
 * 2021/8/29 21:22
 */
public class TimerTask {

    public final long endTime;
    public final Runnable runnable;

    public TimerTask(long endTime, Runnable runnable) {
        this.endTime = endTime;
        this.runnable = runnable;
    }
}
