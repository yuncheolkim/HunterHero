package game.module.fish;

/**
 * @author Yunzhe.Jin
 * 2021/5/13 15:57
 */
public class FishAction {
    private int id;

    private int areaId;

    /**
     * 是否在钓鱼
     */
    private boolean fishing;

    /**
     * 等待提竿
     */
    private boolean hook;

    /**
     * 钓鱼是否成功
     */
    private boolean fail;

    /**
     * 开始钓鱼
     */
    public void startFish() {
        fishing = true;
        id++;

    }

    /**
     * 等待提竿
     */
    public void waitHook() {
        hook = true;
    }


    /**
     * 是否在钓鱼
     *
     * @return
     */
    public boolean inFish() {
        return fishing;
    }


    public boolean isFail() {
        return fail;
    }

    /**
     * 提竿
     *
     * @return 提竿是否成功
     */
    public boolean hook() {
        fail = !hook;
        return hook;
    }

    /**
     * 钓鱼结束
     *
     * @return
     */
    public void endFish() {
        fishing = false;
        fail = false;
        hook = false;


    }

    public void setFail(boolean fail) {
        this.fail = fail;
    }


    public int getId() {
        return id;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public void exitArea() {
        areaId = 0;
    }
}
