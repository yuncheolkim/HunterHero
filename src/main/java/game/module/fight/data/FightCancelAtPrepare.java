package game.module.fight.data;

/**
 * 取消比赛
 *
 * @author Yunzhe.Jin
 * 2021/8/28 22:51
 */
public class FightCancelAtPrepare {

    public final long id;
    public final long uid;

    public FightCancelAtPrepare(long id, long uid) {
        this.uid = uid;
        this.id = id;
    }
}
