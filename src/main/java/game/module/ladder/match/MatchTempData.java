package game.module.ladder.match;

/**
 * @author Yunzhe.Jin
 * 2021/8/27 21:16
 */
public class MatchTempData {
    public MatchInfo info;
    public int lowScore;
    public int topScore;

    public int topCount;
    public int lowCount;

    public MatchTempData(MatchInfo info) {
        this.info = info;

        if (info.lastWin) {
            lowScore = info.scoreBase;
            topScore = lowScore + 20;
        } else {
            topScore = info.scoreBase;
            lowScore = topScore - 20;
        }
    }


    /**
     * 是否满足条件
     *
     * @param check
     * @return
     */
    public boolean check(MatchTempData other) {

        return other.lowScore <= this.topScore && other.topScore >= this.lowScore;

    }

}