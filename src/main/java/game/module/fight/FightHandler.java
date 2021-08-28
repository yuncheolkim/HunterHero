package game.module.fight;

import game.base.Logs;
import game.exception.ModuleAssert;
import game.game.enums.ConsumeTypeEnum;
import game.manager.EventManager;
import game.module.battle.*;
import game.module.battle.battle.AutoBattle;
import game.module.battle.battle.HalfManualAction;
import game.module.battle.battle.HalfManualBattle;
import game.module.battle.find.ManualTargetStrategy;
import game.module.battle.hero.creature.CreatureTarget;
import game.module.battle.record.BattleRecord;
import game.module.event.handler.BattleEndEvent;
import game.module.player.ResourceService;
import game.player.Player;
import game.proto.*;
import game.proto.data.FightEnemyInfo;
import game.proto.data.FightHeroPos;
import game.proto.data.PlayerHero;
import game.proto.data.Reward;
import game.proto.no.No;
import game.utils.CalcUtil;
import game.utils.DateUtils;
import game.utils.JsonUtil;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static game.module.fight.FightService.*;

/**
 * 战斗相关入口
 *
 * @author Yunzhe.Jin
 * 2021/2/25 10:04
 */
public class FightHandler {

    /**
     * 战斗开始,计算后推送给前端
     * 自动战斗
     *
     * @param player
     * @param req
     * @return
     */
    public static void fight(final Player player, final FightStartReq req) {
        if (player.getPd().getFightInfoCount() == 0) {
            return;
        }
        // 观看战斗设定为10分钟
        player.D.setFightTime(DateUtils.now() + TimeUnit.MINUTES.toMillis(10));

        final Battle battle = new AutoBattle();

        // enemy
        for (final FightEnemyInfo enemy : player.getPd().getFightInfoList()) {
            final CreatureTarget fightEnemy = HeroFactory.createFightEnemy(enemy);
            fightEnemy.setSide(Side.B);
            fightEnemy.setPos(Pos.from(enemy.getPos()));
            fightEnemy.setSpeed(enemy.getProperty().getSpeed() == 0 ? fightEnemy.getPos().getIndex() : enemy.getProperty().getSpeed());
            fightEnemy.setBattle(battle);
            fightEnemy.setType(0);
            fightEnemy.init();
            battle.addHero(fightEnemy);
        }

        // player
        for (final FightHeroPos fightHeroPos : req.getPosList()) {
            final PlayerHero playerHero = player.getPd().getHeroMap().get(fightHeroPos.getHeroId());
            if (playerHero == null) {
                return;
            }
            final Hero hero = HeroFactory.createPlayerHero(player, playerHero);
            hero.setSide(Side.A);
            hero.setPos(Pos.from(fightHeroPos.getPos()));
            hero.setSpeed(fightHeroPos.getOrder());
            hero.setBattle(battle);
            hero.setType(1);
            hero.init();

            battle.addHero(hero);
        }

        // 开始战斗
        final BattleRecord record = battle.start();

        final FightRecord.Builder result = buildFightRecord(record);
        result.setWin(record.getWinSide() == Side.A);
        if (player.consumePower(ConsumeTypeEnum.野外战斗, ResourceService.calcPower(player.D.getFightType())) && result.getWin()) {
            List<Reward> rewardList = fightReward(player, record);
            result.addAllReward(rewardList);
        }
        player.getTransport().send(No.FightStartReq, result.build());

        if (player.pd.getBattleId() != 0) {
            BattleEndEvent event = new BattleEndEvent();
            event.battleId = player.pd.getBattleId();
            event.success = result.getWin();
            EventManager.firePlayerEvent(player, event);
        }

        FightService.endFight(player);
    }

    /**
     * 结束战斗
     *
     * @param player
     * @param req
     */
    public static void endFight(final Player player) {
        FightService.endFight(player);

        // 是否还在战斗区域
        if (player.D.getFightAreaCount() > 0) {
            player.D.setFightTime(DateUtils.now() + CalcUtil.random(5000, 20000));
        }
    }


    /**
     * 进入战役
     *
     * @param player
     */
    public static void battleEnter(final Player player, final BattleEnterReq req) {
        FightService.battleEnter(player, req.getId());
    }

    /**
     * 练习场
     *
     * @param player
     * @param req
     */
    public static FightTestRes fightExercise(final Player player, final FightTestReq req) {

        final Battle battle = new Battle();
        // enemy
        for (final FightEnemyInfo enemy : req.getBList()) {
            final CreatureTarget hero = HeroFactory.createFightEnemy(enemy);
            hero.setSide(Side.B);
            hero.setPos(Pos.from(enemy.getPos()));
            hero.setType(0);
            hero.init();
            hero.setBattle(battle);
            battle.addHero(hero);
        }

        // player
        for (final FightHeroPos fightHeroPos : req.getAList()) {
            final PlayerHero playerHero = player.getPd().getHeroMap().get(fightHeroPos.getHeroId());
            final Hero hero = HeroFactory.createPlayerHero(player, playerHero);
            hero.setSide(Side.A);
            hero.setPos(Pos.from(fightHeroPos.getPos()));
            hero.setType(1);
            hero.init();
            hero.setBattle(battle);

            battle.addHero(hero);
        }

        final BattleRecord record = battle.start();
        final FightRecord.Builder result = buildFightRecord(record);

        return FightTestRes.newBuilder().setWin(record.getWinSide() == Side.A)
                .setRecord(result).buildPartial();

    }


    /////////////////////////  手动战斗

    /**
     * 手动战斗 - 开始战斗
     *
     * @param player
     * @param req
     */
    public static void manualFight(final Player player, final FightStartReq req) {
        if (player.hmBattle != null) {
            Logs.C.warn("战斗已经存在");
            return;
        }
        ModuleAssert.isTrue(player.pd.getManual());

        final HalfManualBattle battle = new HalfManualBattle();
        player.hmBattle = battle;

        // enemy
        for (final FightEnemyInfo enemy : player.getPd().getFightInfoList()) {
            final CreatureTarget hero = HeroFactory.createFightEnemy(enemy);
            hero.setSide(Side.B);
            hero.setPos(Pos.from(enemy.getPos()));
            hero.setSpeed(enemy.getProperty().getSpeed() == 0 ? hero.getPos().getIndex() : enemy.getProperty().getSpeed());
            hero.setBattle(battle);
            hero.setType(0);
            hero.init();
            battle.addHero(hero);
        }

        // player
        for (final FightHeroPos fightHeroPos : req.getPosList()) {
            final PlayerHero playerHero = player.getPd().getHeroMap().get(fightHeroPos.getHeroId());
            if (playerHero == null) {
                return;
            }
            final Hero hero = HeroFactory.createPlayerHero(player, playerHero);
            hero.setSide(Side.A);
            hero.setPos(Pos.from(fightHeroPos.getPos()));
            hero.setSpeed(fightHeroPos.getOrder());
            hero.addTargetStrategyFirst(ManualTargetStrategy.I);
            hero.setBattle(battle);
            hero.setType(1);
            hero.init();

            battle.addHero(hero);
        }

        battle.setSideAPid(player.getPid());
        battle.setPve(true);
        BattleRecord start = battle.start();
        final FightRecord.Builder result = buildFightRecord(start);


        FightHmStartRes res = FightHmStartRes.newBuilder()
                .addAllSideA(result.getSideAList())
                .addAllSideB(result.getSideBList()).build();

        player.getTransport().send(No.FightHmStartReq, res);
    }

    /**
     * 手动战斗 - 操作
     *
     * @param player
     * @param req
     */
    public static void manualFightAction(final Player player, final FightHmActionReq req) {

        HalfManualBattle hmBattle = player.hmBattle;
        if (hmBattle == null || hmBattle.hasWinner()) {
            return;
        }

        HalfManualAction action = new HalfManualAction();
        action.pid = player.getPid();
        action.actions = req.getPosList();
        Round ready = hmBattle.ready(action);
        Logs.trace(JsonUtil.toJsonString(ready));

        player.getTransport().send(No.FightHmActionReq, FightHmActionRes.newBuilder().setRound(roundReport(ready)).build());
        if (hmBattle.hasWinner()) {
            FightHmEndPush.Builder result = FightHmEndPush.newBuilder();
            // win
            result.setWin(hmBattle.isWin(player.getPid()));

            if (result.getWin()) {
                // reward
                List<Reward> rewardList = fightReward(player, hmBattle.getBattleRecord());
                result.addAllReward(rewardList);
            }

            player.getTransport().send(No.FightHmEndPush, result.buildPartial());
            if (player.pd.getBattleId() != 0) {
                BattleEndEvent event = new BattleEndEvent();
                event.battleId = player.pd.getBattleId();
                event.success = result.getWin();
                EventManager.firePlayerEvent(player, event);
            }

            FightService.endFight(player);

        }
    }
}
