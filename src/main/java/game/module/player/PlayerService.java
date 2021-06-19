package game.module.player;

import game.game.FeatureEnum;
import game.player.Player;
import game.proto.FeatureOpenPush;
import game.proto.no.No;

/**
 * @author Yunzhe.Jin
 * 2021/6/19 13:21
 */
public class PlayerService {


    public static void openFeature(Player player, FeatureEnum featureEnum) {
        player.pd.setOpenFeature(player.pd.getOpenFeature() | featureEnum.id);
        player.send(No.FeatureOpenPush, FeatureOpenPush.newBuilder()
                .setId(featureEnum.id).build());
    }
}
