package game.module.ladder.match;

/**
 * @author Yunzhe.Jin
 * 2021/9/6 23:22
 */
public class MatchCancel {

    public final long uid;
    public final String matchId;

    public MatchCancel(long uid, String matchId) {

        this.uid = uid;
        this.matchId = matchId;
    }
}
