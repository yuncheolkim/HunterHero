package game.module.scene;

import game.base.Logs;
import game.exception.ModuleAssert;
import game.manager.ConfigManager;
import game.player.Player;
import game.proto.EnterFightAreaReq;
import game.proto.EnterSceneReq;
import game.proto.ExitFightAreaReq;
import game.utils.CalcUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 场景处理
 *
 * @author Yunzhe.Jin
 * 2021/2/25 11:13
 */
public class SceneHandler {

    /**
     * 进入场景
     *
     * @param player
     * @param req
     * @return
     */
    public static void enterScene(final Player player, final EnterSceneReq req) {
        Logs.C.info("进入场景：{}", req.getData().getId());
        ModuleAssert.isPositive(req.getData().getId());
        player.getPd().mergeSceneData(req.getData());
        player.D.clearFightArea();
    }

    /**
     * 进入战斗区域
     *
     * @param player
     * @param req
     * @return
     */
    public static void enterFightArea(final Player player, final EnterFightAreaReq req) {

        Logs.C.info("进入战斗区域：{}", req.getId());
        if (!player.D.getFightAreaList().contains(req.getId()) && ConfigManager.getFightArea(req.getId()) != null) {
            player.D.addFightArea(req.getId());
            final long now = System.currentTimeMillis();
            if (player.D.getFightTime() < now) {
                player.D.setFightTime(now + CalcUtil.random(5000, 10000));
            }
        }

    }

    /**
     * 离开战斗区域
     *
     * @param player
     * @param req
     * @return
     */
    public static void exitFightArea(final Player player, final ExitFightAreaReq req) {
        Logs.C.info("离开战斗区域：{}", req.getId());

        final List<Integer> l = new ArrayList<>(player.D.getFightAreaList());
        l.remove(new Integer(req.getId()));
        player.D.clearFightArea().addAllFightArea(l);
        player.D.setFightTime(0);
    }

}
