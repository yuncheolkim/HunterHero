package game.module.player;

import game.base.G;
import game.config.TransformConfigData;
import game.config.param.ParamConfigData;
import game.exception.ModuleAssert;
import game.game.ResourceSourceEnum;
import game.module.fight.FightService;
import game.player.Player;
import game.proto.*;
import game.proto.data.Resource;
import game.proto.data.ScenePos;
import game.proto.no.No;

import java.util.concurrent.TimeUnit;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 16:00
 */
public class PlayerHandler {
    public static HeartbeatRes heartbeat(Player player, HeartbeatReq o) {
        return HeartbeatRes.newBuilder().setTime(o.getTime()).buildPartial();
    }

    /**
     * 起名
     *
     * @param player
     * @param o
     * @return
     */
    public static void createName(Player player, PlayerCreateNameReq o) {

        player.getPd().setName(o.getName());
        player.getTransport().send(3, Empty.getDefaultInstance());
    }


    /**
     * 移动
     *
     * @param player
     * @param req
     */
    public static void move(Player player, PlayerMoveReq req) {
        ScenePos.Builder posBuilder = player.pd.getSceneDataBuilder().getPosBuilder();
        posBuilder.setX(req.getX()).setY(req.getY());
    }

    /**
     * 回城
     *
     * @param player
     */
    public static void hotel(Player player) {
        long now = System.currentTimeMillis();

        ModuleAssert.isTrue(now >= player.pd.getHotelCd());

        ParamConfigData paramConfigData = G.C.getParamConfigData();

        long cd = now + paramConfigData.hotelCdTime;
        player.pd.setHotelCd(cd);

        player.getTransport().send(No.PlayerGoHotelReq_VALUE, PlayerGoHotelRes.newBuilder().setTime(cd).buildPartial());
    }

    /**
     * 选择回城点
     *
     * @param player
     */
    public static PlayerChooseHotelRes chooseHotel(Player player, PlayerChooseHotelReq req) {
        final int id = req.getId();
        TransformConfigData transformConfigData = G.C.transformConfigData(id);
        ModuleAssert.notNull(transformConfigData);
        player.pd.setHotelId(id);

        return PlayerChooseHotelRes.newBuilder().setId(id).buildPartial();
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 玩家定时器
     * 每5秒执行一次
     *
     * @param player
     * @param o
     * @return
     */
    public static void tick(Player player) {

        // 体力恢复
        recoverPower(player);

        // 检查战斗
        FightService.checkFight(player);

    }


    /**
     * 恢复体力
     */
    public static void recoverPower(Player player) {

        long now = System.currentTimeMillis();

        long second = TimeUnit.MILLISECONDS.toSeconds(now - player.D.getPowerRecoverTime());
        Resource.Builder resourceBuilder = player.getPd().getResourceBuilder();
        int powerRecoverSecond = resourceBuilder.getPowerRecoverSecond();
        if (second >= powerRecoverSecond) {
            long recover = second / powerRecoverSecond;
            player.addPower(recover, ResourceSourceEnum.自动恢复);
            player.D.setPowerRecoverTime(player.D.getPowerRecoverTime() + 1000L * recover * powerRecoverSecond);
        }
    }


    /**
     * 定时存db
     *
     * @param player
     * @param o
     * @return
     */
    public static void dataFlush(Player player, Empty o) {
//        Logs.C.info("保存玩家数据:{}", player.getPid());
        player.saveData();
    }
}
