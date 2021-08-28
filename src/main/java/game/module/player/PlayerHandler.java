package game.module.player;

import game.base.G;
import game.config.data.ParamConfigData;
import game.config.data.TransformConfigData;
import game.exception.ErrorEnum;
import game.exception.ModuleAssert;
import game.game.enums.ConsumeTypeEnum;
import game.game.enums.ResourceSourceEnum;
import game.manager.ConfigManager;
import game.module.fight.FightService;
import game.module.fight.data.FightFormation;
import game.player.Player;
import game.proto.*;
import game.proto.back.LadderPrepare;
import game.proto.data.Resource;
import game.proto.data.ScenePos;
import game.proto.no.No;

import java.util.concurrent.TimeUnit;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 16:00
 */
public class PlayerHandler {
    public static HeartbeatRes heartbeat(final Player player, final HeartbeatReq o) {
        return HeartbeatRes.newBuilder().setTime(o.getTime()).buildPartial();
    }

    /**
     * 起名
     *
     * @param player
     * @param o
     * @return
     */
    public static void createName(final Player player, final PlayerCreateNameReq o) {

        player.getPd().setName(o.getName());
        player.getTransport().send(3, Empty.getDefaultInstance());
    }


    /**
     * 移动
     *
     * @param player
     * @param req
     */
    public static void move(final Player player, final PlayerMoveReq req) {
        final ScenePos.Builder posBuilder = player.pd.getSceneDataBuilder().getPosBuilder();
        posBuilder.setX(req.getX()).setY(req.getY());
    }

    /**
     * 回城
     *
     * @param player
     */
    public static void hotel(final Player player) {
        final long now = System.currentTimeMillis();

        ModuleAssert.isTrue(now >= player.pd.getHotelCd());

        final ParamConfigData paramConfigData = G.C.getParamConfigData();

        final long cd = now + paramConfigData.hotelCdTime;
        player.pd.setHotelCd(cd);

        player.getTransport().send(No.PlayerGoHotelReq_VALUE, PlayerGoHotelRes.newBuilder().setTime(cd).buildPartial());
    }

    /**
     * 选择回城点
     *
     * @param player
     */
    public static PlayerChooseHotelRes chooseHotel(final Player player, final PlayerChooseHotelReq req) {
        final int id = req.getId();
        final TransformConfigData transformConfigData = G.C.transformConfigData(id);
        ModuleAssert.notNull(transformConfigData);
        player.pd.setHotelId(id);

        return PlayerChooseHotelRes.newBuilder().setId(id).buildPartial();
    }

    /**
     * 增加体力
     *
     * @param player
     */
    public static void addPower(final Player player, final RecoverPowerReq req) {
        ModuleAssert.isFalse(player.isFullPower(), ErrorEnum.ERR_6);
        if (req.getType() == 1) {//全部
            ModuleAssert.isTrue(player.consumeGem(ConsumeTypeEnum.购买体力, ConfigManager.paramConfigData.powerRecoverFullGem),
                    ErrorEnum.ERR_7);

            player.resetPower(ResourceSourceEnum.购买体力);

        } else {
            // 恢复一点

            if (req.getGem() > 0) {
                player.consumeGemAssert(ConsumeTypeEnum.购买体力, req.getGem() * ConfigManager.paramConfigData.powerRecoverGem);
                player.addPower(1, ResourceSourceEnum.购买体力);
            } else if (req.getGold() > 0) {
                player.consumeGold(req.getGold() * ConfigManager.paramConfigData.powerRecoverGold, ConsumeTypeEnum.购买体力);
                player.addPower(1, ResourceSourceEnum.购买体力);
            }

        }

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
    public static void tick(final Player player) {

        // 体力恢复
        recoverPower(player);

        // 检查战斗
        FightService.checkFight(player);

    }

    /**
     * 准备排位战斗信息
     * 英雄信息计算
     *
     * @param player
     */
    public static void prepareLadder(final Player player, LadderPrepare req) {
        if (req.getType() == 1) {//单挑

            int heroId = player.pd.getLadderInfoBuilder().getHeroId();

            FightFormation formation = new FightFormation();
            formation.id = req.getId();
            formation.uid = player.getPid();

        }

    }


    /**
     * 恢复体力
     */
    public static void recoverPower(final Player player) {

        final long now = System.currentTimeMillis();

        final long second = TimeUnit.MILLISECONDS.toSeconds(now - player.D.getPowerRecoverTime());
        final Resource.Builder resourceBuilder = player.getPd().getResourceBuilder();
        final int powerRecoverSecond = resourceBuilder.getPowerRecoverSecond();
        if (second >= powerRecoverSecond) {
            final long recover = second / powerRecoverSecond;
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
    public static void dataFlush(final Player player, final Empty o) {
        player.saveData();
    }

}
