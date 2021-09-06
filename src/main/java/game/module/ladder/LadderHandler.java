package game.module.ladder;

import game.anno.GameHandler;
import game.base.G;
import game.exception.ModuleAssert;
import game.module.battle.Side;
import game.module.fight.FightService;
import game.module.fight.data.FightCancelAtPrepare;
import game.module.fight.data.FightFormation;
import game.module.ladder.match.MatchCancel;
import game.module.ladder.match.MatchInfoMsg;
import game.player.Player;
import game.proto.Empty;
import game.proto.LadderCancelReq;
import game.proto.LadderResultPush;
import game.proto.LadderSetFormationReq;
import game.proto.back.LadderData;
import game.proto.back.LadderPrepare;
import game.proto.back.LadderResult;
import game.proto.data.LadderInfo;
import game.proto.data.PlayerHero;
import game.proto.no.No;
import game.utils.DateUtils;

/**
 * 排位赛
 * 单挑
 *
 * @author Yunzhe.Jin
 * 2021/4/15 15:35
 */
public class LadderHandler {

    /**
     * 设置战斗阵型
     *
     * @param player
     * @param req
     */

    @GameHandler(No.LadderSetFormationReq)
    public static void formation(final Player player, final LadderSetFormationReq req) {
        PlayerHero heroOrDefault = player.pd.getHeroOrDefault(req.getHeroId(), null);
        ModuleAssert.notNull(heroOrDefault);
        player.pd.getLadderSingleInfoBuilder().setHeroId(req.getHeroId());
    }

    /**
     * 找对手
     *
     * @param player
     * @param req
     */
    @GameHandler(No.LadderMatchReq)
    public static void match(final Player player) {
        LadderInfo.Builder ladderInfoBuilder = player.pd.getLadderSingleInfoBuilder();
        LadderData.Builder ladderData = player.D.getLadderDataBuilder();
        PlayerHero heroOrDefault = player.pd.getHeroOrDefault(ladderInfoBuilder.getHeroId(), null);
        ModuleAssert.notNull(heroOrDefault);
        ModuleAssert.isFalse(ladderInfoBuilder.getInMatch());

        // 开始匹配
        MatchInfoMsg matchInfoMsg = new MatchInfoMsg();
        matchInfoMsg.uid = player.getPid();
        matchInfoMsg.order = ladderInfoBuilder.getOrder();
        matchInfoMsg.score = ladderInfoBuilder.getScore();
        matchInfoMsg.matchTime = DateUtils.now();
        matchInfoMsg.lastWin = ladderInfoBuilder.getReportCount() != 0 && ladderInfoBuilder.getReport(0).getWinId() == player.getPid();
        matchInfoMsg.scoreBase = ladderData.getLadderSingleScore();

        G.G.getLadderMatchScene().tell(matchInfoMsg);

        ladderInfoBuilder.setInMatch(true);
    }

    /// inner msg

    /**
     * 准备排位战斗信息
     * 英雄信息计算
     *
     * @param player
     */
    @GameHandler(value = No.LadderPrepareInner, inner = true)
    public static void prepareLadder(final Player player, LadderPrepare req) {
        if (req.getType() == 1) {//单挑
            LadderInfo.Builder ladderInfoBuilder = player.pd.getLadderSingleInfoBuilder();
            if (ladderInfoBuilder.getInMatch()) {

                int heroId = ladderInfoBuilder.getHeroId();
                FightFormation formation = new FightFormation();
                formation.side = req.getOrder() == 1 ? Side.A : Side.B;
                formation.id = req.getId();
                formation.uid = player.getPid();
                formation.heroList.add(FightService.createFightHero(player, heroId));
                G.G.getFightScene().tell(formation);
            } else {
                G.G.getFightScene().tell(new FightCancelAtPrepare(req.getId(), player.getPid()));
            }
        }
    }

    /**
     * 玩家取消匹配
     *
     * @param player
     */
    @GameHandler(No.LadderCancelReq)
    public static void ladderCanceled(final Player player, LadderCancelReq req) {
        if (req.getType() == 1) {
            // 单挑
            LadderInfo.Builder ladderInfoBuilder = player.pd.getLadderSingleInfoBuilder();
            if (ladderInfoBuilder.getInMatch()) {

                G.G.getLadderMatchScene().tell(new MatchCancel(player.getPid()));
            }
        }

    }


///////////////////////////////////////////////  inner

    /**
     * 内部发生 排位取消匹配
     *
     * @param player
     */
    @GameHandler(value = No.LadderCancelInner, inner = true)
    public static void ladderCancel(final Player player) {
        LadderInfo.Builder ladderInfoBuilder = player.pd.getLadderSingleInfoBuilder();
        if (ladderInfoBuilder.getInMatch()) {

            ladderInfoBuilder.setInMatch(false);
            // push->client
            player.send(No.LadderCancelPush, Empty.getDefaultInstance());

        }

    }

    /**
     * 排位战斗结果
     *
     * @param player
     * @param req
     */
    @GameHandler(value = No.LadderResultInner, inner = true)
    public static void ladderResult(final Player player, LadderResult req) {
        LadderInfo.Builder ladderInfoBuilder = player.pd.getLadderSingleInfoBuilder();

        if (ladderInfoBuilder.getInMatch()) {

            ladderInfoBuilder.setInMatch(false);

            LadderResultPush result = LadderResultPush.newBuilder()
                    .setRecord(req.getRecord())
                    .buildPartial();

            // todo 计算结果
            player.getTransport().send(No.LadderResultPush, result);

        }
    }
}
