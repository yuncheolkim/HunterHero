package game.utils;

import game.config.base.DataConfigData;
import game.game.ItemTypeEnum;
import game.manager.ConfigManager;
import game.proto.data.ItemData;
import game.proto.data.Reward;
import game.proto.data.RewardType;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 奖励
 *
 * @author Yunzhe.Jin
 * 2021/3/26 20:50
 */
public class RewardUtil {


    public static List<Reward> make(String s) {

        if (StringUtils.isEmpty(s)) {
            return Collections.emptyList();
        }
        List<Reward> list = new ArrayList<>(2);

        for (String item : s.split("#")) {
            Reward.Builder reward = Reward.newBuilder();
            String[] split = item.split("=");
            int count = 1;
            int id = Integer.parseInt(split[0]);

            if (split.length == 2) {
                count = Integer.parseInt(split[1]);
            }
            RewardType type = RewardType.REWARD_RESOURCE;
            if (id > 99) {
                type = RewardType.REWARD_ITEM;
            }

            if (type == RewardType.REWARD_ITEM) {
                // 装备生成property
                DataConfigData itemData = ConfigManager.getItem(id);
                if (itemData.type1 == ItemTypeEnum.EQUIPMENT.id) {
                    reward.setProperty(ConfigManager.makeProperty(itemData));
                }
            }

            list.add(reward.setRewardId(id)
                    .setCount(count)
                    .setType(type)
                    .buildPartial());
        }
        return list;
    }

    public static ItemData rewardToItemData(Reward reward) {
        return ItemData.newBuilder()
                .setItemId(reward.getRewardId())
                .setCount(reward.getCount())
                .setProperty(reward.getProperty())
                .build();
    }


}
