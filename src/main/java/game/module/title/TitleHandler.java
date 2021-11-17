package game.module.title;

import game.exception.EvilAssert;
import game.manager.ConfigManager;
import game.module.player.Player;
import game.proto.TitleChooseReq;
import game.proto.TitleChooseRes;

import static game.base.constants.EvilErrorConstants.E1;

/**
 * 称谓
 *
 * @author Yunzhe.Jin
 * 2021/4/15 15:38
 */
public class TitleHandler {

    public static TitleChooseRes TitleChooseReq(final Player player, final TitleChooseReq req) {
        EvilAssert.isTrue(player.pd.getCollectTitleList().contains(req.getId()), E1);

        player.pd.setTitle(ConfigManager.getTitle(req.getId()).name);

        return TitleChooseRes.newBuilder().setId(req.getId()).build();
    }
}



