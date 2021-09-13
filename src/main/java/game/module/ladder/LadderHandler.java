package game.module.ladder;

import game.anno.GameHandler;
import game.base.G;
import game.base.Logs;
import game.exception.ErrorEnum;
import game.exception.ModuleAssert;
import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Pos;
import game.module.battle.Side;
import game.module.fight.FightService;
import game.module.fight.data.FightCancelAtPrepare;
import game.module.fight.data.FightFormation;
import game.module.ladder.match.MatchCancel;
import game.module.ladder.match.MatchInfoMsg;
import game.player.Player;
import game.proto.*;
import game.proto.back.*;
import game.proto.data.*;
import game.proto.no.No;
import game.utils.DateUtils;

import static game.game.enums.ConsumeTypeEnum.单挑排位;

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
        ModuleAssert.isFalse(player.pd.getInMatch());
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
    public static void matchSingle(final Player player, LadderMatchReq req) {

        ModuleAssert.isFalse(player.pd.getInMatch());

        if (req.getType() == 2) {
            matchMulti(player, req);
        } else if (req.getType() == 1) {

            LadderInfo.Builder build = player.pd.getLadderSingleInfoBuilder();
            LadderData.Builder ladderData = player.D.getLadderDataBuilder();
            PlayerHero heroOrDefault = player.pd.getHeroOrDefault(build.getHeroId(), null);
            ModuleAssert.notNull(heroOrDefault);

            ModuleAssert.isTrue(player.hasPower(ConfigManager.paramConfigData.ladderSingleFight), ErrorEnum.ERR_10);

            player.pd.setInMatch(true);
            player.pd.setMatchId(req.getId());

            // 开始匹配
            MatchInfoMsg matchInfoMsg = new MatchInfoMsg();
            matchInfoMsg.id = req.getId();
            matchInfoMsg.uid = player.getPid();
            matchInfoMsg.order = build.getOrder();
            matchInfoMsg.score = build.getScore();
            matchInfoMsg.matchTime = DateUtils.now();
            matchInfoMsg.lastWin = build.getReportCount() != 0 && build.getReport(0).getWinId() == player.getPid();
            matchInfoMsg.scoreBase = ladderData.getLadderSingleScore();

            G.G.getLadderSingleMatchScene().tell(matchInfoMsg);
        }

        player.pd.setInMatch(true);
    }

    /**
     * Normal match
     *
     * @param player
     * @param req
     */
    private static void matchMulti(final Player player, LadderMatchReq req) {

        LadderInfo.Builder build = player.pd.getLadderMultiInfoBuilder();
        LadderData.Builder ladderData = player.D.getLadderDataBuilder();
        ModuleAssert.isTrue(player.hasPower(ConfigManager.paramConfigData.ladderFight), ErrorEnum.ERR_10);

        player.pd.setInMatch(true);
        player.pd.setMatchId(req.getId());

        // 开始匹配
        MatchInfoMsg matchInfoMsg = new MatchInfoMsg();
        matchInfoMsg.id = req.getId();
        matchInfoMsg.uid = player.getPid();
        matchInfoMsg.order = build.getOrder();
        matchInfoMsg.score = build.getScore();
        matchInfoMsg.matchTime = DateUtils.now();
        matchInfoMsg.lastWin = build.getReportCount() != 0 && build.getReport(0).getWinId() == player.getPid();
        matchInfoMsg.scoreBase = ladderData.getLadderMultiScore();

        G.G.getLadderMultiMatch().tell(matchInfoMsg);
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
            if (player.pd.getInMatch()) {
                G.G.getLadderSingleMatchScene().tell(new MatchCancel(player.getPid(),
                        player.getPid() + "-" + player.pd.getMatchId()));
            }
        } else if (req.getType() == 2) {
            if (player.pd.getInMatch()) {
                G.G.getLadderMultiMatch().tell(new MatchCancel(player.getPid(),
                        player.getPid() + "-" + player.pd.getMatchId()));
            }
        }
        player.pd.setInMatch(false);
    }

    /**
     * 结束
     *
     * @param player
     * @param req
     */
    @GameHandler(No.LadderFightEndReq)
    public static void ladderFightEndReq(final Player player, LadderFightEndReq req) {
        PlayerData.Builder ladderInfoBuilder = player.pd;

        if (ladderInfoBuilder.getInMatch() && req.getMatchId() == ladderInfoBuilder.getMatchId()) {
            ladderInfoBuilder.setMatchId(0);
            ladderInfoBuilder.setInMatch(false);
        }

    }
///////////////////////////////////////////////  inner

    /**
     * 准备排位战斗信息
     * 英雄信息计算
     *
     * @param player
     */
    @GameHandler(value = No.LadderPrepareInner, inner = true)
    public static void prepareLadder(final Player player, LadderPrepare req) {

        if (!player.pd.getInMatch()) {

            G.G.getFightScene().tell(new FightCancelAtPrepare(req.getMatchId(), player.getPid()));
            return;
        }
        LadderInfo.Builder ladderInfoBuilder = null;
        FightFormation formation = new FightFormation();
        if (req.getType() == 1) {//单挑
            ladderInfoBuilder = player.pd.getLadderSingleInfoBuilder();
            Hero fightHero = FightService.createFightHero(player, ladderInfoBuilder.getHeroId());
            fightHero.setPos(Pos.from(formation.side == Side.A ? 0 : 16));
            formation.heroList.add(fightHero);
        } else if (req.getType() == 2) {// 6人
            ladderInfoBuilder = player.pd.getLadderMultiInfoBuilder();


            // todo
//            fightHero.setPos(Pos.from(formation.side == Side.A ? 0 : 16));
//            formation.heroList.add(fightHero);
        }

        formation.userName = player.pd.getName();
        formation.side = req.getOrder() == 1 ? Side.A : Side.B;
        formation.matchId = req.getMatchId();
        formation.uid = player.getPid();
        formation.score = ladderInfoBuilder.getScore();
        G.G.getFightScene().tell(formation);
    }

    /**
     * 内部发生 排位取消匹配
     *
     * @param player
     */
    @GameHandler(value = No.LadderCancelInner, inner = true)
    public static void ladderCancel(final Player player, LadderCancelInner inner) {
        PlayerData.Builder ladderInfoBuilder = player.pd;

        if (ladderInfoBuilder.getInMatch() && inner.getId() == ladderInfoBuilder.getMatchId()) {
            ladderInfoBuilder.setMatchId(0);
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
        LadderInfo.Builder ladder = player.pd.getLadderSingleInfoBuilder();

        // 这里不能马上变为非匹配
        // 不然会立刻进入野外战斗
        // 需要一个战斗结束消息来结束, 但这里进行保底, 2分钟后设置为false
        player.scheduleAfter(120 * 1000, No.LadderFightAutoEndInner.getNumber(), LadderFightAutoEndInner.newBuilder()
                .setMatchId(player.pd.getMatchId()).buildPartial());

        Logs.C.debug("单挑结果:{}", req.getScore());
        boolean win = player.getPid() == req.getRecord().getWinUid();

        LadderHeroScore.Builder heroScoreOrDefault = ladder.getHeroScoreOrDefault(ladder.getHeroId(), LadderHeroScore.newBuilder().build()).toBuilder();
        LadderData.Builder ladderDataBuilder = player.D.getLadderDataBuilder();
        if (win) {
            ladderDataBuilder.setLadderSingleScore(ladderDataBuilder.getLadderSingleScore() + 20);
        } else {
            ladderDataBuilder.setLadderSingleScore(Math.min(0, ladderDataBuilder.getLadderSingleScore() - 20));
        }

        // Calc score
        if (ladder.getOrder() == 1) {
            //先手
            ladder.setOrder(2);
            if (win) {
                ladder.setWin1(ladder.getWin1() + 1);
                heroScoreOrDefault.setWin1(heroScoreOrDefault.getWin1() + 1);
            } else {
                ladder.setLose1(ladder.getLose1() + 1);
                heroScoreOrDefault.setLose1(heroScoreOrDefault.getLose1() + 1);
            }
        } else {
            ladder.setOrder(1);
            if (win) {
                ladder.setWin2(ladder.getWin2() + 1);
                heroScoreOrDefault.setWin2(heroScoreOrDefault.getWin2() + 1);
            } else {
                ladder.setLose2(ladder.getLose2() + 1);
                heroScoreOrDefault.setLose2(heroScoreOrDefault.getLose2() + 1);
            }
        }

        ladder.putHeroScore(ladder.getHeroId(), heroScoreOrDefault.build());
        ladder.setScore(ladder.getScore() + req.getScore());
        // 战报
        LadderSingleReport report = LadderSingleReport.newBuilder()
                .setWinId(req.getRecord().getWinUid())
                .setFirst(req.getFirstUid())
                .setP1(req.getP1())
                .setP2(req.getP2())
                .build();
        ladder.addReport(0, report);

        if (ladder.getReportCount() > 20) {
            ladder.removeReport(20);
        }
        // 消耗体力
        player.consumePower(单挑排位, ConfigManager.paramConfigData.ladderSingleFight);

        LadderResultPush result = LadderResultPush.newBuilder()
                .setRecord(req.getRecord())
                .setScore(ladder.getScore())
                .setAdd(req.getScore())
                .setReport(report)
                .buildPartial();
        player.getTransport().send(No.LadderResultPush, result);
    }

    /**
     * 自动结束观看战斗
     *
     * @param player
     * @param req
     */
    @GameHandler(value = No.LadderFightAutoEndInner, inner = true)
    public static void ladderFightAutoEndInner(final Player player, LadderFightAutoEndInner req) {
        PlayerData.Builder builder = player.pd;
        if (builder.getMatchId() == req.getMatchId()) {
            builder.setInMatch(false);
            builder.setMatchId(0);
        }
    }
}
