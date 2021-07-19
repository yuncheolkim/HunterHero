package game.module.fight;

import game.base.Logs;
import game.base.constants.GameConstants;
import game.base.util.Tuple2;
import game.config.box.BattleFormationDataBox;
import game.exception.ErrorEnum;
import game.exception.EvilAssert;
import game.exception.ModuleAssert;
import game.exception.ModuleException;
import game.game.ConsumeTypeEnum;
import game.game.ResourceEnum;
import game.game.ResourceSourceEnum;
import game.manager.ConfigManager;
import game.manager.EventManager;
import game.module.battle.*;
import game.module.battle.battle.AutoBattle;
import game.module.battle.battle.HalfManualAction;
import game.module.battle.battle.HalfManualBattle;
import game.module.battle.find.ManualTargetStrategy;
import game.module.battle.hero.creature.CreatureTarget;
import game.module.battle.record.BattleRecord;
import game.module.battle.record.HeroRecordData;
import game.module.battle.record.Record;
import game.module.event.handler.KillEvent;
import game.module.item.ItemDropService;
import game.module.player.ResourceService;
import game.module.task.TaskService;
import game.player.Player;
import game.proto.*;
import game.proto.back.MsgNo;
import game.proto.data.*;
import game.proto.no.No;
import game.utils.CalcUtil;
import game.utils.DateUtils;
import game.utils.ResourceCalcUtil;
import io.netty.util.collection.IntObjectHashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
        player.getTransport().send(MsgNo.fight_start_VALUE, result.build());

    }

    private static List<Reward> fightReward(Player player, BattleRecord record) {
        int gold = 0;

        final IntObjectHashMap<Integer> enemyCountMap = new IntObjectHashMap<>(record.getSideBhero().size());

        List<Reward> rewardList = new ArrayList<>(16);
        final List<Tuple2<Integer, Integer>> expList = new ArrayList<>(8);
        // 杀敌
        for (final HeroRecordData sideBhero : record.getSideBhero()) {
            final int enemyId = sideBhero.simple.id;
            final int earnExp = ItemDropService.dropExp(sideBhero.simple.level);
            expList.add(new Tuple2<>(sideBhero.simple.level, earnExp));
            gold += ItemDropService.enemyDropGold(sideBhero.simple.level);
            Integer enemyCount = enemyCountMap.get(enemyId);
            if (enemyCount == null) {
                enemyCount = 0;
            }
            enemyCount += 1;
            enemyCountMap.put(enemyId, enemyCount);

            // enemy item
            List<Reward> itemRewardList = ItemDropService.dropEnemyItem(enemyId);
            if (!itemRewardList.isEmpty()) {
                rewardList.addAll(itemRewardList);
//                result.addAllReward(itemRewardList);
            }
            // task item
            itemRewardList = TaskService.dropEnemyItem(player, enemyId);
            if (!itemRewardList.isEmpty()) {
                rewardList.addAll(itemRewardList);
//                result.addAllReward(itemRewardList);
            }
        }

        // 记录杀敌
        for (final Map.Entry<Integer, Integer> entry : enemyCountMap.entrySet()) {
            EventManager.firePlayerEvent(player, new KillEvent(entry.getKey(), entry.getValue()));
        }
        // 奖励
        if (gold > 0) {
            rewardList.add(Reward.newBuilder()
                    .setType(RewardType.REWARD_RESOURCE)
                    .setHeroId(0)
                    .setRewardId(ResourceEnum.GOLD.id)
                    .setCount(gold)
                    .build());

            player.addGold(gold, ResourceSourceEnum.打怪);
        }

        // area item
        final List<Reward> itemRewardList = ItemDropService.dropAreaItem(player.pd.getSceneData().getId());
        if (!itemRewardList.isEmpty()) {
            rewardList.addAll(itemRewardList);
        }


        // 经验
        // 计算衰减
        final int playerExt = ResourceCalcUtil.calcExp(player.pd.getLevel(), expList);
        player.addPlayerExp(playerExt, ResourceSourceEnum.打怪);
        rewardList.add(Reward.newBuilder()
                .setType(RewardType.REWARD_RESOURCE)
                .setHeroId(0)
                .setRewardId(ResourceEnum.EXP.id)
                .setCount(playerExt)
                .build());
        // Add hero exp
        for (final HeroRecordData sideAhero : record.getSideAhero()) {
            final int exp = ResourceCalcUtil.calcExp(sideAhero.simple.level, expList);
            player.addHeroExp(sideAhero.simple.id, exp, ResourceSourceEnum.打怪);

            rewardList.add(Reward.newBuilder()
                    .setType(RewardType.REWARD_RESOURCE)
                    .setHeroId(sideAhero.simple.id)
                    .setRewardId(ResourceEnum.EXP.id)
                    .setCount(exp)
                    .build());
        }
        // 发道具奖励
        for (final Reward reward : rewardList) {
            if (reward.getType() == RewardType.REWARD_ITEM) {
                try {
                    player.addItem(ItemData.newBuilder().setItemId(reward.getRewardId())
                            .setCount(reward.getCount())
                            .setProperty(reward.getProperty())
                            .build(), GameConstants.ITEM_BAG);
                } catch (final Exception e) {
                    if (e instanceof ModuleException) {
                        player.getTransport().sendError((ErrorEnum) ((ModuleException) e).getErrorNo());
                    }
                    // 加入失败, 背包满
                    Logs.C.error(e);
                    player.getTransport().sendError(ErrorEnum.ERR_104);
                    break;
                }
            }
        }
        return rewardList;
    }

    private static FightRecord.Builder buildFightRecord(final BattleRecord record) {
        final FightRecord.Builder builder = FightRecord.newBuilder();
        for (final HeroRecordData hero : record.getSideAhero()) {
            builder.addSideA(HeroDataRecord.newBuilder()
                    .setId(hero.simple.id)
                    .setHp(hero.simple.hp)
                    .setName(hero.simple.name)
                    .setPos(hero.simple.pos.getIndex())
                    .build());
        }
        for (final HeroRecordData hero : record.getSideBhero()) {
            builder.addSideB(HeroDataRecord.newBuilder()
                    .setId(hero.simple.id)
                    .setHp(hero.simple.hp)
                    .setLevel(hero.simple.level)
                    .setName(hero.simple.name)
                    .setPos(hero.simple.pos.getIndex())
                    .build());
        }

        if (record.getRoundList() != null) {

            for (final Round round : record.getRoundList()) {

                builder.addRound(roundReport(round));
            }

        }
        return builder;

    }

    private static RoundRecord roundReport(Round round) {
        final RoundRecord.Builder rb = RoundRecord.newBuilder();
        for (final Record r : round.getRecordList()) {
            final game.proto.data.Record.Builder re = game.proto.data.Record.newBuilder();
            re.setType(r.type);
            re.setId(r.id);
            re.setValue(r.value);
            if (r.dp != null) {
                re.setDp(r.dp);
            }
            re.setPos(r.pos);
            if (r.damageType != null) {
                re.setDamageType(r.damageType);
            }
            if (r.actionPoint != null) {
                re.setActionPoint(r.actionPoint.name());
            }
            re.setHeroId(r.heroId);
            re.setDp(r.dp);
            if (r.targetList != null) {
                re.addAllTarget(r.targetList);
            }
            if (r.buffData != null) {
                re.getBuffRecordBuilder().setBuffId(r.buffData.buffId);
                re.getBuffRecordBuilder().setRemainRound(r.buffData.remainRound);
            }
            rb.addRecord(re.build());
        }
        return rb.buildPartial();
    }

    /**
     * 结束战斗
     *
     * @param player
     * @param req
     */
    public static void endFight(final Player player) {
        player.pd.clearFightInfo();
        player.pd.setBattleId(0);
        player.hmBattle = null;

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
        final BattleFormationDataBox formationDataBox = ConfigManager.battleFormationDataBox;
        EvilAssert.notNull(formationDataBox.findByCollectId(req.getId()), "战役不存在");
        ModuleAssert.isFalse(player.getPd().getFightInfoCount() > 0, ErrorEnum.ERR_113);

        final FightStartPush fightStartPush = FightService.genBattleEnemy(req.getId());

        player.pd.addAllFightInfo(fightStartPush.getInfoList());
        player.pd.setBattleId(req.getId());
        player.getTransport().send(Message.newBuilder()
                .setMsgNo(No.FightStartPush_VALUE)
                .setBody(fightStartPush.toByteString())
                .build());
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
            final CreatureTarget fightEnemy = HeroFactory.createFightEnemy(enemy);
            fightEnemy.setSide(Side.B);
            fightEnemy.setPos(Pos.from(enemy.getPos()));
            fightEnemy.init();
            fightEnemy.setBattle(battle);
            battle.addHero(fightEnemy);
        }

        // player
        for (final FightHeroPos fightHeroPos : req.getAList()) {
            final PlayerHero playerHero = player.getPd().getHeroMap().get(fightHeroPos.getHeroId());
            final Hero hero = HeroFactory.createPlayerHero(player, playerHero);
            hero.setSide(Side.A);
            hero.setPos(Pos.from(fightHeroPos.getPos()));
            hero.addTargetStrategyFirst(ManualTargetStrategy.I);
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

        final HalfManualBattle battle = new HalfManualBattle();
        player.hmBattle = battle;

        // enemy
        for (final FightEnemyInfo enemy : player.getPd().getFightInfoList()) {
            final CreatureTarget fightEnemy = HeroFactory.createFightEnemy(enemy);
            fightEnemy.setSide(Side.B);
            fightEnemy.setPos(Pos.from(enemy.getPos()));
            fightEnemy.setSpeed(enemy.getProperty().getSpeed() == 0 ? fightEnemy.getPos().getIndex() : enemy.getProperty().getSpeed());
            fightEnemy.setBattle(battle);
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
        if (hmBattle == null) {
            return;
        }

        HalfManualAction action = new HalfManualAction();
        action.pid = player.getPid();
        action.actions = req.getPosList();
        Round ready = hmBattle.ready(action);

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
        }
    }
}
