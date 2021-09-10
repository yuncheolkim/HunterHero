package game.module.ladder;

/**
 * @author Yunzhe.Jin
 * 2021/9/10 22:28
 */
public class LadderTempData {
    public long matchId;
    public boolean inMatch;

    public void reset() {
        inMatch = false;
        matchId = 0;
    }
}
