package game.game.scene;

import game.base.G;
import game.base.Logs;
import game.base.Work;
import game.base.constants.GameConstants;
import game.utils.DateUtils;

import java.util.LinkedList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 游戏场景基本类
 *
 * @author Yunzhe.Jin
 * 2021/4/2 15:36
 */
public class Scene {
    private int sceneId;

    protected long id;

    private Work work;

    protected ScheduledExecutorService schedule;

    protected LinkedList<TimerTask> task = new LinkedList<>();

    public Scene() {
        id = GameConstants.TEMP_ID_GENERATOR.next();
        schedule = getSchedule();
    }

    public void tell(final Object msg) {
        final Scene that = this;
        work.addTask(() -> {
            that.beforeProcess();
            that.process(msg);
        });
    }

    private void beforeProcess() {

        if (!task.isEmpty()) {
            final long now = DateUtils.now();
            for (TimerTask timerTask : task) {
                if (timerTask.endTime <= now) {
                    try {
                        timerTask.runnable.run();
                    } catch (Exception e) {
                        Logs.C.error(e);
                    }
                }
            }
        }
    }

    protected void process(final Object msg) {

    }

    public void setWork(final Work work) {
        this.work = work;
    }


    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(final int sceneId) {
        this.sceneId = sceneId;
    }


    protected ScheduledExecutorService getSchedule() {
        return G.W.getDefaultSchedule();
    }

    protected void doScheduleMillisecond(long time, Object msg) {
        schedule.schedule(() -> tell(msg), time, TimeUnit.MILLISECONDS);
    }

    protected void doScheduleSecond(long second, Object msg) {
        schedule.schedule(() -> tell(msg), second, TimeUnit.SECONDS);
    }

    protected void doScheduleSecond(long second, Runnable runnable) {
        schedule.schedule(runnable, second, TimeUnit.SECONDS);
    }

    public void addTimer(long afterMillesecond, Runnable runnable) {
        task.add(new TimerTask(DateUtils.now() + afterMillesecond, runnable));
    }

    public long getId() {
        return id;
    }
}
