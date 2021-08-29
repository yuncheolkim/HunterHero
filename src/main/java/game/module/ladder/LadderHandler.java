package game.module.ladder;

import game.anno.InsideMsgHandler;
import game.base.G;
import game.exception.ModuleAssert;
import game.module.fight.FightService;
import game.module.fight.data.FightCancelAtPrepare;
import game.module.fight.data.FightFormation;
import game.module.ladder.match.MatchInfo;
import game.player.Player;
import game.proto.Empty;
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
    
    public static void formation(final Player player, final LadderSetFormationReq req) {
        PlayerHero heroOrDefault = player.pd.getHeroOrDefault(req.getHeroId(), null);
        ModuleAssert.notNull(heroOrDefault);
        player.pd.getLadderInfoBuilder().setHeroId(req.getHeroId());
    }

    /**
     * 找对手
     *
     * @param player
     * @param req
     */
    public static void match(final Player player) {
        LadderInfo.Builder ladderInfoBuilder = player.pd.getLadderInfoBuilder();
        LadderData.Builder ladderData = player.D.getLadderDataBuilder();
        PlayerHero heroOrDefault = player.pd.getHeroOrDefault(ladderInfoBuilder.getHeroId(), null);
        ModuleAssert.notNull(heroOrDefault);
        ModuleAssert.isFalse(ladderInfoBuilder.getInMatch());

        // 开始匹配
        MatchInfo matchInfo = new MatchInfo();
        matchInfo.uid = player.getPid();
        matchInfo.order = ladderInfoBuilder.getOrder();
        matchInfo.score = ladderInfoBuilder.getScore();
        matchInfo.matchTime = DateUtils.now();
        matchInfo.lastWin = ladderInfoBuilder.getReportCount() != 0 && ladderInfoBuilder.getReport(0).getWinId() == player.getPid();
        matchInfo.scoreBase = ladderData.getLadderSingleScore();

        G.G.getLadderMatchScene().tell(matchInfo);

        ladderInfoBuilder.setInMatch(true);
    }

    /// inner msg

    /**
     * 准备排位战斗信息
     * 英雄信息计算
     *
     * @param player
     */
    @InsideMsgHandler
    public static void prepareLadder(final Player player, LadderPrepare req) {
        if (req.getType() == 1) {//单挑
            LadderInfo.Builder ladderInfoBuilder = player.pd.getLadderInfoBuilder();
            if (ladderInfoBuilder.getInMatch()) {

                int heroId = ladderInfoBuilder.getHeroId();
                FightFormation formation = new FightFormation();
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
     * 排位取消匹配
     *
     * @param player
     */
    @InsideMsgHandler
    public static void ladderCancel(final Player player) {
        LadderInfo.Builder ladderInfoBuilder = player.pd.getLadderInfoBuilder();
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
    @InsideMsgHandler
    public static void ladderResult(final Player player, LadderResult req) {
        LadderInfo.Builder ladderInfoBuilder = player.pd.getLadderInfoBuilder();

        if (ladderInfoBuilder.getInMatch()) {

            ladderInfoBuilder.setInMatch(false);
            // push

        }
    }

}
