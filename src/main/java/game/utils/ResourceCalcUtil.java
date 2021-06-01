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

    public static int calcExp(int level, List<Tuple2<Integer, Integer>> list) {

        int exp = 0;

        for (Tuple2<Integer, Integer> v : list) {
            Integer enemyLevel = v.first;
            Integer earnExt = v.second;

            int diff = level - enemyLevel;

            if (diff > 3) {// 差距大于3级

                exp += CalcUtil.calcRateAdd(earnExt, 100 - (diff - 3) * 20);

            } else {
                exp += earnExt;
            }
        }


        return exp;
    }
}
