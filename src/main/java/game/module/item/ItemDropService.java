package game.module.item;

import game.config.data.DropItemAreaConfigData;
import game.config.data.DropItemEnemyConfigData;
import game.config.data.ExpConfigData;
import game.config.data.ItemConfigData;
import game.game.enums.ItemTypeEnum;
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
    public static int enemyDropGold(int enemyLevel) {
        ExpConfigData dataConfigData = ConfigManager.getExp(enemyLevel);
        return CalcUtil.random(dataConfigData.minGold, dataConfigData.maxGold);
    }

    /**
     * 掉落经验
     * 根据怪等等级进行衰减
     *
     * @param enemyLevel
     * @return
     */
    public static int dropExp(int enemyLevel) {
        ExpConfigData dataConfigData = ConfigManager.getExp(enemyLevel);
        return dataConfigData.monsterExp;
    }

    /**
     * 敌人掉落物品
     *
     * @param enemyId
     * @return
     */
    public static List<Reward> dropEnemyItem(int enemyId) {

        List<DropItemEnemyConfigData> dropItemConfigData = ConfigManager.dropItemEnemyDataBox.findByCollectId(enemyId);

        if (dropItemConfigData == null) {
            return Collections.emptyList();
        }

        List<Reward> list = new ArrayList<>(2);
        // enemy
        for (DropItemEnemyConfigData d : dropItemConfigData) {
            if (CalcUtil.happened10000(d.rate)) {
                Reward.Builder builder = Reward.newBuilder().setType(RewardType.REWARD_ITEM)
                        .setCount(d.count)
                        .setRewardId(d.itemId);
                ItemConfigData item = ConfigManager.getItem(d.itemId);
                if (item.type == ItemTypeEnum.EQUIPMENT) {
                    builder.setProperty(item.property);
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
        List<DropItemAreaConfigData> dropItemConfigData = ConfigManager.dropItemAreaDataBox.findByCollectId(areaId);

        if (dropItemConfigData == null) {
            return Collections.emptyList();
        }

        List<Reward> list = new ArrayList<>(2);
        // area

        for (DropItemAreaConfigData d : dropItemConfigData) {
            if (CalcUtil.happened10000(d.rate)) {
                Reward.Builder builder = Reward.newBuilder().setType(RewardType.REWARD_ITEM)
                        .setCount(d.count)
                        .setRewardId(d.itemId);
                ItemConfigData item = ConfigManager.getItem(d.itemId);
                if (item.type == ItemTypeEnum.EQUIPMENT) {
                    builder.setProperty(item.property);
                }
                list.add(builder.build());
            }
        }

        return list;
    }

}
