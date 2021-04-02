package game.game.scene;

import game.base.GameConstants;
import game.base.Work;

/**
 * @author Yunzhe.Jin
 * 2021/4/2 15:36
 */
public class GameScene {
    protected long id;

    private Work work;

    public GameScene() {
        id = GameConstants.ID_GENERATOR.next();
    }

    public void tell(Object msg) {
        GameScene that = this;
        work.addTask(() -> {
            that.process(msg);
        });
    }

    protected void process(Object msg) {

    }

    public void setWork(Work work) {
        this.work = work;
    }


}
