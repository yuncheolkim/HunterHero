package game.game.scene;

import game.base.Work;
import game.base.constants.GameConstants;

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

    public GameScene() {
        id = GameConstants.ID_GENERATOR.next();
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
}
