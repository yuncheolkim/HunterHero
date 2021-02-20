package game.module.battle;

import java.util.List;

/**
 * 查找敌人策略
 *
 * @author Yunzhe.Jin
 * 2021/1/13 14:19
 */
public interface FindTargetStrategy {

    /**
     * @param search 正在执行的英雄
     * @param found  结果列表
     *
     * @return 是否继续查找
     */
    boolean find(Hero search, List<Hero> found);
}
