package game.module.scene;

import game.base.G;
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
    public static void enterScene(Player player, EnterSceneReq req) {
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
    public static void enterFightArea(Player player, EnterFightAreaReq req) {

        if (!player.D.getFightAreaList().contains(req.getId()) && G.C.getFightArea(req.getId()) != null) {
            player.D.addFightArea(req.getId());
            long now = System.currentTimeMillis();
            if (player.D.getFightTime() < now) {
                player.D.setFightTime(now + CalcUtil.random(5000, 20000));
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
    public static void exitFightArea(Player player, ExitFightAreaReq req) {
        List<Integer> l = new ArrayList<>(player.D.getFightAreaList());
        l.remove(new Integer(req.getId()));
        player.D.clearFightArea().addAllFightArea(l);
        player.D.setFightTime(0);
    }

}
