package game.module.player;

import game.base.Logs;
import game.game.enums.FeatureEnum;
import game.player.Player;
import game.proto.FeatureOpenPush;
import game.proto.NpcShowChangePush;
import game.proto.data.NpcShowEnum;
import game.proto.no.No;

/**
 * @author Yunzhe.Jin
 * 2021/6/19 13:21
 */
public class PlayerService {

    /**
     * 开始新功能
     *
     * @param player
     * @param featureEnum
     */
    public static void openFeature(Player player, FeatureEnum featureEnum) {
        player.pd.setOpenFeature(player.pd.getOpenFeature() | featureEnum.id);
        player.send(No.FeatureOpenPush, FeatureOpenPush.newBuilder()
                .setId(featureEnum.index).build());
    }

    /**
     * 是否开始某项功能
     *
     * @param player
     * @param featureEnum
     * @return
     */
    public static boolean isOpenFeature(Player player, FeatureEnum featureEnum) {
        return (player.pd.getOpenFeature() & 1 << featureEnum.id) != 0;
    }

    /**
     * Show or hide a npc
     *
     * @param player
     * @param npcId
     */
    public static void showOrHideNpc(Player player, int npcId, boolean show) {
        int i = 0;
        switch (npcId) {
            case 14://苏离
                i = NpcShowEnum.NPC_SHOW_1_VALUE;
                break;
        }

        if (i == 0) {
            Logs.C.warn("Not found show npc:{}", npcId);
            return;
        }
        player.pd.setShowNpc(player.pd.getShowNpc() | i);

        if (!show) {
            player.pd.setShowNpc((player.pd.getShowNpc() | i) ^ i);
        }

        player.send(No.NpcShowChangePush, NpcShowChangePush.newBuilder()
                .setShowNo(player.pd.getShowNpc())
                .setNpcId(npcId)
                .build());
    }
}
