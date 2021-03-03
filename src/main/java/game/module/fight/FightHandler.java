package game.module.fight;

import com.google.protobuf.MessageLite;
import game.player.Player;
import game.proto.FightStartReq;
import game.proto.data.FightHeroPos;
import game.proto.data.PlayerHero;

/**
 * 战斗相关入口
 * @author Yunzhe.Jin
 * 2021/2/25 10:04
 */
public class FightHandler {

    /**
     * 战斗开始
     * @param player
     * @param req
     * @return
     */
    public static void fight(Player player, FightStartReq req) {

        for (FightHeroPos fightHeroPos : req.getPosList()) {
            PlayerHero playerHero = player.getPd().getHeroMap().get(fightHeroPos.getHeroId());
            if (playerHero == null) {
                return;
            }
        }
    }
}
