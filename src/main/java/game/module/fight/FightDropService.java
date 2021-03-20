package game.module.fight;

import game.base.G;
import game.config.DataConfigData;
import game.config.drop.DropItemConfigData;
import game.proto.data.Reward;
import game.proto.data.RewardType;
import game.utils.CalcUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/3/20 14:52
 */
public class FightDropService {

    public static int dropGold(int enemyLevel) {
        DataConfigData dataConfigData = G.C.dataMap9.get(enemyLevel);
        return CalcUtil.random(dataConfigData.min, dataConfigData.max);
    }

    public static int dropExp(int enemyLevel) {
        DataConfigData dataConfigData = G.C.dataMap9.get(enemyLevel);
        return dataConfigData.monsterExp;
    }

    /**
     * 敌人掉落物品
     *
     * @param enemyId
     * @return
     */
    public static List<Reward> dropEnemyItem(int enemyId) {

        List<DropItemConfigData> dropItemConfigData = G.C.enemyDropMap.get(enemyId);

        if (dropItemConfigData == null) {
            return Collections.emptyList();
        }

        List<Reward> list = new ArrayList<>(2);
        // nemey

        for (DropItemConfigData d : dropItemConfigData) {
            if (CalcUtil.happened10000(d.rate)) {
                list.add(Reward.newBuilder().setType(RewardType.REWARD_ITEM)
                        .setCount(d.count)
                        .setRewardId(d.itemId).build());
            }
        }

        return list;
    }

    /**
     * 区域掉落物品
     *
     * @param areaId
     * @return
     */
    public static List<Reward> dropAreaItem(int areaId) {
        List<DropItemConfigData> dropItemConfigData = G.C.areaDropMap.get(areaId);

        if (dropItemConfigData == null) {
            return Collections.emptyList();
        }

        List<Reward> list = new ArrayList<>(2);
        // area

        for (DropItemConfigData d : dropItemConfigData) {
            if (CalcUtil.happened10000(d.rate)) {
                list.add(Reward.newBuilder().setType(RewardType.REWARD_ITEM)
                        .setCount(d.count)
                        .setRewardId(d.itemId).build());
            }
        }

        return list;
    }

}
