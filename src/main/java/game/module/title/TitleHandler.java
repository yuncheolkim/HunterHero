package game.module.title;

import game.exception.EvilAssert;
import game.player.Player;
import game.proto.TitleChooseReq;
import game.proto.TitleChooseRes;

/**
 * 称谓
 *
 * @author Yunzhe.Jin
 * 2021/4/15 15:38
 */
public class TitleHandler {

    public static TitleChooseRes TitleChooseReq(final Player player, final TitleChooseReq req) {
        EvilAssert.isTrue(player.pd.getCollectTitleList().contains(req.getId()), () -> "称谓不存在");

        return null;
    }
}



