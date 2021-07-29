package game.module.escort;

import game.config.data.ExpressConfigData;
import game.exception.ErrorEnum;
import game.exception.EvilAssert;
import game.exception.ModuleAssert;
import game.game.enums.ConsumeTypeEnum;
import game.game.enums.Counter;
import game.game.enums.ResourceSourceEnum;
import game.manager.ConfigManager;
import game.player.Player;
import game.proto.ExpressCompleteReq;
import game.proto.ExpressCompleteRes;
import game.proto.ExpressInfoRes;
import game.proto.ExpressStartRqRs;
import game.proto.data.ExpressInfo;

/**
 * 跑镖
 *
 * @author Yunzhe.Jin
 * 2021/7/26 22:26
 */
public class ExpressHandler {

    public static ExpressInfoRes info(final Player player) {


        return null;
    }


    /**
     * 开始跑镖
     *
     * @param player
     * @param req
     */
    public static ExpressStartRqRs start(final Player player, final ExpressStartRqRs req) {
        ModuleAssert.isFalse(player.pd.hasExpressInfo(), ErrorEnum.ERR_202);
        final ExpressConfigData data = ConfigManager.expressDataBox.findById(req.getId());
        EvilAssert.notNull(data, "不存在跑镖配置");
        // 检查次数
        ModuleAssert.isTrue(Counter.EXPRESS.Reduce(player), ErrorEnum.ERR_9);

        player.consumePowerAssert(ConsumeTypeEnum.跑镖, data.power);
        player.pd.setExpressInfo(ExpressInfo.newBuilder().setId(data.id));
        return req;
    }

    /**
     * 完成跑镖
     *
     * @param player
     * @param req
     * @return
     */
    public static ExpressCompleteRes complete(final Player player, final ExpressCompleteReq req) {
        ModuleAssert.isTrue(player.pd.hasExpressInfo(), ErrorEnum.ERR_202);

        final ExpressConfigData data = ConfigManager.expressDataBox.findById(player.pd.getExpressInfo().getId());
        player.addGold(data.gold, ResourceSourceEnum.跑镖);

        return ExpressCompleteRes.getDefaultInstance();
    }

}
