package game.module.dungeon;

import game.anno.GameHandler;
import game.config.data.DungeonConfigData;
import game.config.data.DungeonInfoConfigData;
import game.exception.EvilAssert;
import game.exception.ModuleAssert;
import game.manager.ConfigManager;
import game.module.fight.FightService;
import game.player.Player;
import game.proto.*;
import game.proto.data.Dungeon;
import game.proto.no.No;

/**
 * 副本
 *
 * @author Yunzhe.Jin
 * 2021/7/24 18:30
 */
public class DungeonHandler {


    /**
     * 进入副本
     *
     * @param player
     */
    @GameHandler(No.DungeonEnterReq)
    public static DungeonEnterRes enter(Player player, DungeonEnterReq req) {
        ModuleAssert.isFalse(player.pd.hasDungeon());
        DungeonInfoConfigData d = ConfigManager.dungeonInfoDataBox.findById(req.getId());
        EvilAssert.notNull(d, "副本不存在");

        player.pd.setDungeon(Dungeon.newBuilder().setId(d.id));

        return DungeonEnterRes.getDefaultInstance();
    }

    /**
     * 战斗
     *
     * @param player
     */
    @GameHandler(No.DungeonFightReq)
    public static void fight(Player player, DungeonFightReq req) {
        DungeonConfigData data = ConfigManager.dungeonDataBox.findById(req.getTargetId());
        player.pd.getDungeonBuilder().setBossId(req.getTargetId());
        FightService.battleDungeon(player, data.battleId);
    }

    /**
     * 离开副本
     *
     * @param player
     * @param req
     */
    @GameHandler(No.DungeonExitReq)
    public static DungeonExitRes exit(Player player, DungeonExitReq req) {
        player.pd.clearDungeon();

        return DungeonExitRes.getDefaultInstance();
    }

}
