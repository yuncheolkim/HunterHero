package game.module.fight.data;

/**
 * 取消比赛
 *
 * @author Yunzhe.Jin
 * 2021/8/28 22:51
 */
public class FightCancelAtPrepare {

    public final long matchId;
    public final long uid;

    public FightCancelAtPrepare(long matchId, long uid) {
        this.uid = uid;
        this.matchId = matchId;
    }
}
