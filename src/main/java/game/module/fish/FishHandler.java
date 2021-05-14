package game.module.fish;

import game.base.G;
import game.exception.ModuleAssert;
import game.game.ConsumeTypeEnum;
import game.player.FishAction;
import game.player.Player;
import game.proto.FishHookReq;
import game.proto.FishPush;
import game.proto.FishReq;
import game.proto.back.FishData;
import game.proto.back.MsgNoBackInner;
import game.proto.no.No;
import game.utils.CalcUtil;

import static game.exception.ErrorEnum.ERR_110;
import static game.exception.ErrorEnum.ERR_111;

/**
 * 钓鱼系统
 *
 * @author Yunzhe.Jin
 * 2021/4/15 15:28
 */
public class FishHandler {

    /**
     * 钓鱼
     *
     * @param player
     * @param req
     */
    public static void fish(Player player, FishReq req) {

        // todo 检查是否在钓鱼区域

        FishAction fishAction = player.fishAction;
        ModuleAssert.isFalse(fishAction.inFish(), ERR_110);
        // 消耗体力
        player.consumePower(G.C.powerFish(), ConsumeTypeEnum.钓鱼);

        // 开始钓鱼
        fishAction.startFish();

        player.scheduleAfter(
                CalcUtil.random(3000, 8000)
                , MsgNoBackInner.B_FISH_HOOK_VALUE
                , FishData.newBuilder().setId(fishAction.getId()).buildPartial());

    }

    /**
     * 提竿
     *
     * @param player
     * @param req
     */
    public static void fishHook(Player player, FishHookReq req) {

        // todo 检查是否在钓鱼区域

        FishAction fishAction = player.fishAction;
        ModuleAssert.isTrue(fishAction.inFish(), ERR_111);

        // 提竿
        if (fishAction.hook()) {
            // 成功
            player.getTransport().send(
                    No.FishHookReq_VALUE,
                    FishPush.newBuilder().setSuccess(true).buildPartial()
            );
        } else {
            //失败
            player.getTransport().send(
                    No.FishHookReq_VALUE,
                    FishPush.newBuilder().setSuccess(false).buildPartial()
            );

        }
        fishAction.endFish();

    }


    /**
     * inner
     * <p>
     * 提竿阶段
     *
     * @param player
     * @param req
     * @return
     */
    public static void fishHook(Player player, FishData fishData) {
        FishAction fishAction = player.fishAction;
        if (fishAction.inFish() && fishAction.getId() == fishData.getId()) {
            player.fishAction.waitHook();
            // 提竿
            player.scheduleAfter(
                    G.C.getParamConfigData().fishSuccessTime,
                    MsgNoBackInner.B_FISH_HOOK_EXPIRE_VALUE,
                    fishData
            );
        }
    }


    /**
     * 提竿超时
     *
     * @param player
     */
    public static void waitHook(Player player, FishData fishData) {
        FishAction fishAction = player.fishAction;
        if (fishAction.inFish() && fishAction.getId() == fishData.getId()) {
            //失败
            player.getTransport().send(No.FishReq_VALUE, FishPush.newBuilder().setSuccess(false).buildPartial());
            fishAction.endFish();
        }
    }

}
