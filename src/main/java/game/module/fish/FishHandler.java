package game.module.fish;

import game.base.G;
import game.config.data.FishWeightConfigData;
import game.exception.ModuleAssert;
import game.game.enums.ConsumeTypeEnum;
import game.manager.ConfigManager;
import game.module.player.Player;
import game.proto.*;
import game.proto.back.FishData;
import game.proto.data.Reward;
import game.proto.data.RewardType;
import game.proto.no.No;
import game.utils.CalcUtil;
import game.utils.RewardUtil;

import java.util.List;

import static game.exception.ErrorEnum.*;

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

        ModuleAssert.isTrue(player.pd.getFishAreaId() > 0, ERR_112);

        // 消耗体力
        player.consumePower(ConsumeTypeEnum.钓鱼, G.C.powerFish());

        // 开始钓鱼
        fishAction.startFish();

        player.scheduleAfter(
                CalcUtil.random(3000, 8000)
                , No.B_FISH_HOOK_VALUE
                , FishData.newBuilder().setId(fishAction.getId()).buildPartial());

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

            player.send(No.FishHookPush, FishHookPush.getDefaultInstance());

            // 提竿
            player.scheduleAfter(
                    G.C.getParamConfigData().fishSuccessTime,
                    No.B_FISH_HOOK_EXPIRE_VALUE,
                    fishData
            );
        }
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
        fishAction.hook();


        FishPush.Builder builder = FishPush.newBuilder()
                .setSuccess(!fishAction.isFail());

        if (!fishAction.isFail()) {
            List<FishWeightConfigData> fishList = ConfigManager.fishWeightAreaDataBox.findByCollectId(fishAction.getAreaId());
            Reward reward = Reward.newBuilder()
                    .setRewardId(CalcUtil.weightRandom(fishList).fishId)
                    .setCount(1)
                    .setType(RewardType.REWARD_ITEM)

                    .build();
            builder.addReward(reward);

            player.addItemToBag(RewardUtil.rewardToItemData(reward));
        }
        player.getTransport().send(
                No.FishReq_VALUE,
                builder
                        .buildPartial()
        );
        fishAction.endFish();

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

    /**
     * 进入捕鱼区
     *
     * @param player
     * @param fishData
     */
    public static void enterArea(Player player, FishEnterAreaReq fishData) {
        ModuleAssert.notNull(ConfigManager.fishAreaDataBox.findById(fishData.getId()), ERR_112);

        player.pd.setFishAreaId(fishData.getId());

        player.fishAction.setAreaId(fishData.getId());
    }

    public static void exitArea(Player player, FishExitAreaReq fishData) {
        player.pd.setFishAreaId(0);
        player.fishAction.endFish();
        player.fishAction.exitArea();
    }

}
