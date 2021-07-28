package game.game.enums;

import game.proto.back.GameCountInfo;
import org.joda.time.LocalDateTime;

/**
 * 重置次数检查时间点
 *
 * @author Yunzhe.Jin
 * 2021/7/28 21:20
 */
public enum CounterTime {

    /**
     * 零点
     */
    AT_0 {
        public boolean isPass(GameCountInfo.Builder info) {

            if (info.getUpdateTime() == 0) {
                return true;
            }
            LocalDateTime now = LocalDateTime.now().withTime(0, 0, 0, 0);
            LocalDateTime last = new LocalDateTime(info.getUpdateTime());
            return now.isAfter(last);
        }
    };


    /**
     * 是否过了更新点
     *
     * @param info
     * @return
     */
    public boolean isPass(GameCountInfo.Builder info) {

        return false;
    }

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now().withTime(0, 0, 0, 0);


        System.out.println(now.minusHours(1).isBefore(now));

    }
}
