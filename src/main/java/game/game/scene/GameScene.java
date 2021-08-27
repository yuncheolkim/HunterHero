package game.game.scene;

import game.base.G;
import game.base.Work;
import game.base.constants.GameConstants;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 游戏场景基本类
 *
 * @author Yunzhe.Jin
 * 2021/4/2 15:36
 */
public class GameScene {
    private int sceneId;

    protected long id;

    private Work work;

    protected ScheduledExecutorService schedule;

    public GameScene() {
        id = GameConstants.ID_GENERATOR.next();
        schedule = getSchedule();
    }

    public void tell(final Object msg) {
        final GameScene that = this;
        work.addTask(() -> {
            that.process(msg);
        });
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

    protected void doScheduleSecond(long second, Object msg) {
        schedule.schedule(() -> tell(msg), second, TimeUnit.SECONDS);
    }

}
