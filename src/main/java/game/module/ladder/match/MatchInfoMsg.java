package game.module.ladder.match;

import java.util.Objects;

/**
 * 匹配信息
 *
 * @author Yunzhe.Jin
 * 2021/8/26 22:58
 */
public class MatchInfoMsg implements Comparable<MatchInfoMsg> {

    public long id;

    /**
     *
     */
    public long uid;

    /**
     * 1: 先手
     * 2: 后手
     */
    public int order;

    /**
     * 当前分数
     */
    public int score;

    /**
     * 发起匹配时间
     */
    public long matchTime;

    /**
     * 最后一次是否胜利
     */
    public boolean lastWin;

    /**
     * 查找对手分数基线
     */
    public int scoreBase;

    /**
     * 类型
     */
    public int type;

    @Override
    public int compareTo(MatchInfoMsg o) {

        int i = (int) (matchTime - o.matchTime);
        if (i == 0) {
            return (int) (uid - o.uid);
        }
        return i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchInfoMsg matchInfoMsg = (MatchInfoMsg) o;
        return uid == matchInfoMsg.uid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }

    @Override
    public String toString() {
        return "MatchInfo{" +
                "uid=" + uid +
                ", order=" + order +
                ", score=" + score +
                ", matchTime=" + matchTime +
                ", lastWin=" + lastWin +
                ", scoreBase=" + scoreBase +
                '}';
    }
}
