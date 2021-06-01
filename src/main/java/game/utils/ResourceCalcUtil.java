package game.utils;

import java.util.Map;

/**
 * 计算用户最终得到的资源
 *
 * @author Yunzhe.Jin
 * 2021/6/1 21:33
 */
public class ResourceCalcUtil {

    public static int calcExp(int level, Map<Integer, Integer> expMp) {

        int exp = 0;

        for (Map.Entry<Integer, Integer> entry : expMp.entrySet()) {
            Integer enemyLevel = entry.getKey();
            Integer earnExt = entry.getValue();

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
