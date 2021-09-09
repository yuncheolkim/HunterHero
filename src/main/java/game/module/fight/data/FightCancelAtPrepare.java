package game.module.fight.data;

/**
 * 取消比赛
 *
 * @author Yunzhe.Jin
 * 2021/8/28 22:51
 */
public class FightCancelAtPrepare {

    public final String matchId;
    public final long uid;

    public FightCancelAtPrepare(String matchId, long uid) {
        this.uid = uid;
        this.matchId = matchId;
    }
}
