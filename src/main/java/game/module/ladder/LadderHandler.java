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

import java.util.Optional;

import static game.game.enums.ConsumeTypeEnum.单挑排位;
import static game.game.enums.ConsumeTypeEnum.多人排位;
import static game.module.fight.FightService.createFightHero;

/**
 * 排位赛
 * 单挑
 *
 * @author Yunzhe.Jin
 * 2021/4/15 15:35
 */
public class LadderHandler {

    /**
     * 设置单挑英雄
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
    public static void match(final Player player, LadderMatchReq req) {

        ModuleAssert.isFalse(player.pd.getInMatch());

        player.pd.setMatchId(req.getId());
        player.pd.setMatchType(req.getType());
        if (req.getType() == 2) {
            matchMulti(player, req);
        } else if (req.getType() == 1) {

            LadderInfo.Builder build = player.pd.getLadderSingleInfoBuilder();
            LadderData.Builder ladderData = player.D.getLadderDataBuilder();
            PlayerHero heroOrDefault = player.pd.getHeroOrDefault(build.getHeroId(), null);
            ModuleAssert.notNull(heroOrDefault);

            ModuleAssert.isTrue(player.hasPower(ConfigManager.paramConfigData.ladderSingleFight), ErrorEnum.ERR_10);


            // 开始匹配
            MatchInfoMsg matchInfoMsg = new MatchInfoMsg();
            matchInfoMsg.id = req.getId();
            matchInfoMsg.uid = player.getPid();
            matchInfoMsg.order = build.getOrder();
            matchInfoMsg.score = build.getScore();
            matchInfoMsg.matchTime = DateUtils.now();
            matchInfoMsg.lastWin = build.getReportCount() != 0 && build.getReport(0).getWinId() == player.getPid();
            matchInfoMsg.scoreBase = ladderData.getLadderSingleScore();

            G.G.getLadderMatchScene().tell(matchInfoMsg);
        } else {
            return;
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

        ModuleAssert.isTrue(player.pd.getFormationIndexOrDefault(FormationType.FORMATION_LADDER_VALUE, -1) >= 0);

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
                G.G.getLadderMatchScene().tell(new MatchCancel(player.getPid(),
                        player.getPid() + "-" + player.pd.getMatchId()));
            }
        } else if (req.getType() == 2) {
            if (player.pd.getInMatch()) {
                G.G.getLadderMultiMatch().tell(new MatchCancel(player.getPid(),
                        player.getPid() + "-" + player.pd.getMatchId()));
            }
        }
//        player.pd.setInMatch(false);
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


        LadderInfo.Builder ladderInfoBuilder = null;
        FightFormation formation = new FightFormation();
        Side side = req.getOrder() == 1 ? Side.A : Side.B;
        if (req.getType() == 1) {//单挑
            ladderInfoBuilder = player.pd.getLadderSingleInfoBuilder();
            Hero fightHero = FightService.createFightHero(player, ladderInfoBuilder.getHeroId());
            fightHero.setPos(Pos.from(0));
            fightHero.setSide(side);
            fightHero.setSpeed(1);
            formation.battleType = FightType.F_LADDER_SINGLE;
            formation.heroList.add(fightHero);
        } else if (req.getType() == 2) {// multi
            ladderInfoBuilder = player.pd.getLadderMultiInfoBuilder();
            final int formationIndex = player.pd.getFormationIndexOrDefault(FormationType.FORMATION_LADDER_VALUE, -1);
            Optional<Formation.Builder> fightFormation = player.pd.getFormationBuilderList()
                    .stream().filter(builder -> builder.getIndex() == formationIndex).findFirst();
            if (!fightFormation.isPresent()) {
                G.G.getFightScene().tell(new FightCancelAtPrepare(req.getMatchId(), player.getPid()));
                player.send(No.LadderCancelPush, Empty.getDefaultInstance());
                return;
            }
            for (final FormationPos fightHeroPos : fightFormation.get().getPosList()) {
                if (fightHeroPos.getHeroId() == 0) {
                    continue;
                }
                Hero hero = createFightHero(player, fightHeroPos.getHeroId());
                hero.setSide(side);
                hero.setPos(Pos.from(fightHeroPos.getIndex()));
                hero.setSpeed(fightHeroPos.getOrder());
                hero.setType(1);
                hero.init();
                formation.heroList.add(hero);
            }
            formation.battleType = FightType.F_LADDER_MULTI;
        }

        formation.userName = player.pd.getName();
        formation.side = side;
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

        if (ladderInfoBuilder.getInMatch()) {
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

        // 这里不能马上变为非匹配
        // 不然会立刻进入野外战斗
        // 需要一个战斗结束消息来结束, 但这里进行保底, 2分钟后设置为false
        player.scheduleAfter(120 * 1000, No.LadderFightAutoEndInner.getNumber(), LadderFightAutoEndInner.newBuilder()
                .setMatchId(player.pd.getMatchId()).buildPartial());

        if (req.getType() == 1) {
            LadderInfo.Builder ladder = player.pd.getLadderSingleInfoBuilder();

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
                    .setType(1)
                    .buildPartial();
            player.getTransport().send(No.LadderResultPush, result);
        } else {
            LadderInfo.Builder ladder = player.pd.getLadderMultiInfoBuilder();

            Logs.C.debug("Multi结果:{}", req.getScore());
            boolean win = player.getPid() == req.getRecord().getWinUid();

            LadderHeroScore.Builder heroScore = ladder.getHeroScoreOrDefault(ladder.getHeroId(), LadderHeroScore.newBuilder().build()).toBuilder();
            LadderData.Builder ladderDataBuilder = player.D.getLadderDataBuilder();
            if (win) {
                ladderDataBuilder.setLadderMultiScore(ladderDataBuilder.getLadderMultiScore() + 20);
            } else {
                ladderDataBuilder.setLadderMultiScore(Math.min(0, ladderDataBuilder.getLadderMultiScore() - 20));
            }

            // Calc score
            if (ladder.getOrder() == 1) {
                //先手
                ladder.setOrder(2);
                if (win) {
                    ladder.setWin1(ladder.getWin1() + 1);
                    heroScore.setWin1(heroScore.getWin1() + 1);
                } else {
                    ladder.setLose1(ladder.getLose1() + 1);
                    heroScore.setLose1(heroScore.getLose1() + 1);
                }
            } else {
                ladder.setOrder(1);
                if (win) {
                    ladder.setWin2(ladder.getWin2() + 1);
                    heroScore.setWin2(heroScore.getWin2() + 1);
                } else {
                    ladder.setLose2(ladder.getLose2() + 1);
                    heroScore.setLose2(heroScore.getLose2() + 1);
                }
            }

            ladder.putHeroScore(ladder.getHeroId(), heroScore.build());
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
            player.consumePower(多人排位, ConfigManager.paramConfigData.ladderFight);

            LadderResultPush result = LadderResultPush.newBuilder()
                    .setRecord(req.getRecord())
                    .setScore(ladder.getScore())
                    .setAdd(req.getScore())
                    .setReport(report)
                    .setType(2)
                    .buildPartial();
            player.getTransport().send(No.LadderResultPush, result);
        }
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
        if (builder.getInMatch() && builder.getMatchId() == req.getMatchId()) {
            builder.setInMatch(false);
            builder.setMatchId(0);
        }
    }
}
