package game.utils;

import game.base.util.Tuple2;

import java.util.List;

/**
 * 计算用户最终得到的资源
 *
 * @author Yunzhe.Jin
 * 2021/6/1 21:33
 */
public class ResourceCalcUtil {

    public static int calcExp(final int level, final List<Tuple2<Integer, Integer>> list) {

        int exp = 0;

        for (final Tuple2<Integer, Integer> v : list) {
            final Integer enemyLevel = v.first;
            final Integer earnExt = v.second;

            final int diff = level - enemyLevel;

            if (diff > 3) {// 差距大于3级

                exp += CalcUtil.change100(earnExt, 100 - (diff - 3) * 20);

            } else {
                exp += earnExt;
            }
        }


        return exp;
    }
}
