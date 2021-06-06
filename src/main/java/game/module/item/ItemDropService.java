package game.module.item;

import game.base.G;
import game.config.DataConfigData;
import game.config.drop.DropItemConfigData;
import game.game.ItemTypeEnum;
import game.manager.ConfigManager;
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
public class ItemDropService {

    /**
     * 掉落金币
     *
     * @param enemyLevel
     * @return
     */
    public static int dropGold(int enemyLevel) {
        DataConfigData dataConfigData = G.C.dataMap9.get(enemyLevel);
        return CalcUtil.random(dataConfigData.min, dataConfigData.max);
    }

    /**
     * 掉落经验
     * 根据怪等等级进行衰减
     *
     * @param enemyLevel
     * @return
     */
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
        // enemy
        for (DropItemConfigData d : dropItemConfigData) {
            if (CalcUtil.happened10000(d.rate)) {
                Reward.Builder builder = Reward.newBuilder().setType(RewardType.REWARD_ITEM)
                        .setCount(d.count)
                        .setRewardId(d.itemId);
                DataConfigData item = ConfigManager.getItem(d.itemId);
                if (item.type1 == ItemTypeEnum.EQUIPMENT.id) {
                    builder.setProperty(ConfigManager.makeProperty(item));
                }
                list.add(builder.build());

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
                Reward.Builder builder = Reward.newBuilder().setType(RewardType.REWARD_ITEM)
                        .setCount(d.count)
                        .setRewardId(d.itemId);
                DataConfigData item = ConfigManager.getItem(d.itemId);
                if (item.type1 == ItemTypeEnum.EQUIPMENT.id) {
                    builder.setProperty(ConfigManager.makeProperty(item));
                }
                list.add(builder.build());
            }
        }

        return list;
    }

}
