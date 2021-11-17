package game.module.escort;

import game.anno.GameHandler;
import game.base.Logs;
import game.config.data.ExpressConfigData;
import game.exception.ErrorEnum;
import game.exception.EvilAssert;
import game.exception.ModuleAssert;
import game.game.enums.ConsumeTypeEnum;
import game.game.enums.Counter;
import game.game.enums.FeatureEnum;
import game.game.enums.ResourceSourceEnum;
import game.manager.ConfigManager;
import game.module.player.Player;
import game.module.player.PlayerService;
import game.proto.ExpressCompleteReq;
import game.proto.ExpressCompleteRes;
import game.proto.ExpressInfoRes;
import game.proto.ExpressStartRqRs;
import game.proto.data.ExpressInfo;
import game.proto.no.No;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 跑镖
 *
 * @author Yunzhe.Jin
 * 2021/7/26 22:26
 */
public class ExpressHandler {

    /**
     * 打开面板
     *
     * @param player
     * @return
     */
    @GameHandler(No.ExpressOpenReq)
    public static void open(final Player player) {

        // 跑镖数据生成
        if (PlayerService.isOpenFeature(player, FeatureEnum.跑镖)) {
            boolean reduce = Counter.EXPRESS_INFO.Reduce(player);
            if (reduce) {
                // 生成跑镖
                Logs.trace("生成跑镖数据");

                ExpressInfoRes.Builder builder = ExpressInfoRes.newBuilder();
                builder.setUpdate(true);
                List<Integer> all = ConfigManager.expressDataBox.all(expressConfigData -> {
                    return expressConfigData.level <= player.getLevel();
                }).stream().map(expressConfigData -> expressConfigData.id).collect(Collectors.toList());
                Collections.shuffle(all);
                player.pd.addAllExpressId(all.stream().limit(5).collect(Collectors.toList()));
                builder.addAllInfo(all);
                player.send(No.ExpressOpenReq, builder.buildPartial());
                return;
            }
        }

        player.send(No.ExpressOpenReq, ExpressInfoRes.newBuilder().setUpdate(false).buildPartial());
    }


    /**
     * 开始跑镖
     *
     * @param player
     * @param req
     */
    @GameHandler(No.ExpressStartRqRs)
    public static ExpressStartRqRs start(final Player player, final ExpressStartRqRs req) {
        ModuleAssert.isFalse(player.pd.hasExpressInfo(), ErrorEnum.ERR_202);
        int id = req.getId();
        final ExpressConfigData data = ConfigManager.expressDataBox.findById(id);
        EvilAssert.notNull(data, "不存在跑镖配置");

        ModuleAssert.isTrue(player.pd.getExpressIdList().contains(id));

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
    @GameHandler(No.ExpressCompleteReq)
    public static ExpressCompleteRes complete(final Player player, final ExpressCompleteReq req) {
        ModuleAssert.isTrue(player.pd.hasExpressInfo(), ErrorEnum.ERR_202);

        final int expressId = player.pd.getExpressInfo().getId();
        final ExpressConfigData data = ConfigManager.expressDataBox.findById(expressId);

        List<Integer> expressIdList = player.pd.getExpressIdList();
        player.pd.clearExpressId().addAllExpressId(expressIdList.stream()
                .filter(id -> id != expressId).collect(Collectors.toList()));

        player.addGold(data.gold, ResourceSourceEnum.跑镖);
        player.pd.clearExpressInfo();
        return ExpressCompleteRes.newBuilder().setId(expressId).build();
    }

}
