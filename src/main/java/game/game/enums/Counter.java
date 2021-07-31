package game.game.enums;

import game.player.Player;
import game.proto.back.GameCount;
import game.proto.back.GameCountInfo;
import org.joda.time.DateTimeUtils;

/**
 * 计数相关更新
 *
 * @author Yunzhe.Jin
 * 2021/7/28 20:58
 */
public enum Counter {
//    /**
//     * 跑镖次数
//     */
//    EXPRESS(CounterTime.AT_0) {
//        @Override
//        protected int init() {
//            return ConfigManager.paramConfigData.expressCount;
//        }
//
//        @Override
//        public boolean Reduce(Player player, int count) {
//
//            GameCount.Builder countBuilder = player.D.getCountBuilder();
//            GameCountInfo.Builder express = countBuilder.getExpressBuilder();
//
//            refresh(express);
//
//            if (express.getCount() >= count) {
//                express.setCount(express.getCount() - count);
//                countBuilder.setExpress(express);
//                return true;
//            }
//
//            return false;
//
//        }
//    },

    /**
     * 跑镖刷新
     */
    EXPRESS_INFO(CounterTime.AT_0) {
        @Override
        public boolean Reduce(Player player, int count) {
            GameCount.Builder countBuilder = player.D.getCountBuilder();
            GameCountInfo.Builder express = countBuilder.getExpressBuilder();
            refresh(express);

            if (express.getCount() >= count) {
                express.setCount(express.getCount() - count);
                countBuilder.setExpress(express);
                return true;
            }

            return false;
        }

        @Override
        protected int init() {
            return 1;
        }

    };

    /**
     * 检查时间策略
     */
    private CounterTime ct;

    Counter(CounterTime ct) {
        this.ct = ct;
    }

    /**
     * 是否成功减少次数
     *
     * @return
     */
    public boolean Reduce(Player player) {
        return Reduce(player, 1);
    }

    public abstract boolean Reduce(Player player, int count);

    /**
     * 更新数据
     *
     * @param info
     */
    protected void refresh(GameCountInfo.Builder info) {

        if (ct.isPass(info)) {
            info.setCount(init());
        }
        info.setUpdateTime(DateTimeUtils.currentTimeMillis());
    }

    /**
     * 初始化数据
     *
     * @return
     */
    protected abstract int init();
}
