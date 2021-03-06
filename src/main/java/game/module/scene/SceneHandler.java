package game.module.scene;

import game.player.Player;
import game.proto.EnterFightAreaReq;
import game.proto.EnterSceneReq;
import game.proto.ExitFightAreaReq;

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

        if (!player.D.getFightAreaList().contains(req.getId())) {
            player.D.addFightArea(req.getId());
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
        l.remove(req.getId());
        player.D.clearFightArea().addAllFightArea(l);
    }

}
