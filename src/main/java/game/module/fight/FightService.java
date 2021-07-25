package game.module.fight;

import game.base.Logs;
import game.base.constants.GameConstants;
import game.base.util.Tuple2;
import game.config.base.WeightData;
import game.config.box.BattleFormationDataBox;
import game.config.data.*;
import game.exception.ErrorEnum;
import game.exception.EvilAssert;
import game.exception.ModuleAssert;
import game.exception.ModuleException;
import game.game.ResourceEnum;
import game.game.ResourceSourceEnum;
import game.manager.ConfigManager;
import game.manager.EventManager;
import game.module.battle.Round;
import game.module.battle.record.BattleRecord;
import game.module.battle.record.HeroRecordData;
import game.module.event.handler.KillEvent;
import game.module.item.ItemDropService;
import game.module.task.TaskService;
import game.player.Player;
import game.proto.FightRecord;
import game.proto.FightStartPush;
import game.proto.back.FightType;
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
import java.util.function.Consumer;

import static game.module.battle.PosGen.RANDOM_8;

/**
 * @author Yunzhe.Jin
 * 2021/3/19 20:20
 */
public class FightService {

    /**
     * 野外检查战斗
     *
     * @param player
     */
    public static void checkFight(final Player player) {
        if (player.pd.getFightInfoCount() > 0) {
            // 已经在战斗中
            return;
        }

        if (player.D.getFightAreaCount() > 0) {
            // 野外战斗
            player.D.setFightType(FightType.F_BATTLE);
            final long now = DateUtils.now();
            if (player.D.getFightTime() < now) {
                // fight
                final FightStartPush.Builder fightStartPush = genEnemy(player);
                fightStartPush.setManual(false);
                player.getPd().addAllFightInfo(fightStartPush.getInfoList());

                player.send(No.FightStartPush, fightStartPush.buildPartial());
                // 选择英雄时间
                player.D.setFightTime(now + TimeUnit.MINUTES.toMillis(10));
            }
        } else {
            player.D.setFightTime(0);
        }
    }

    /**
     * 生成小怪
     *
     * @param player
     * @return
     */
    private static FightStartPush.Builder genEnemy(final Player player) {

        Logs.C.debug("生成敌人");
        int allWeight = 0;
        final List<WeightData<Integer>> enemyList = new ArrayList<>();
        for (final Integer enemyAreaId : player.D.getFightAreaList()) {
            final Enemy1ConfigData enemy = ConfigManager.enemy1DataBox.findById(enemyAreaId);
            if (enemy != null) {
                allWeight += enemy.allWeight;
                enemyList.addAll(enemy.list);
            }
        }

        // count
        int min = 1;
        int max = 1;
        for (final Integer enemyAreaId : player.D.getFightAreaList()) {
            final EnemyCountConfigData data = ConfigManager.enemyCountDataBox.findById(enemyAreaId);
            min = Math.max(min, data.min);
            max = Math.max(max, data.max);
        }

        final int count = (min ^ max) == 0 ? min : CalcUtil.random(min, max);

        // hero info
        final List<WeightData<Integer>> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            result.add(CalcUtil.weightRandom(enemyList, allWeight));
        }

        // hero pos
        final List<Integer> pos = RANDOM_8.posList(count);

        final FightStartPush.Builder push = FightStartPush.newBuilder();

        for (int i = 0; i < count; i++) {
            final FightEnemyInfo.Builder builder = FightEnemyInfo.newBuilder();
            final WeightData<Integer> d = result.get(i);
            final EnemyPropertyConfigData p = ConfigManager.enemyPropertyDataBox.findById(d.data);

            builder.setId(p.enemyId);
            builder.setPos(pos.get(i));
            builder.setLevel(p.level);
            builder.setType(EnemyType.CREATURE);
            builder.setName(ConfigManager.getEnemyName(p.enemyId));
            builder.setProperty(p.property);

            push.addInfo(builder);
        }

        return push;
    }

    /**
     * 战役
     *
     * @param battleId
     * @return
     */
    public static FightStartPush.Builder genBattleEnemy(final int battleId) {

        final List<BattleFormationConfigData> enemyList = ConfigManager.battleFormationDataBox.findByCollectId(battleId);
        final FightStartPush.Builder push = FightStartPush.newBuilder();
        for (final BattleFormationConfigData d : enemyList) {

            final FightEnemyInfo.Builder builder = FightEnemyInfo.newBuilder();
            builder.setId(d.enemyId);
            builder.setPos(d.pos);
            builder.setLevel(d.level);
            builder.setType(EnemyType.CREATURE);
            builder.setName(ConfigManager.getEnemyName(d.enemyId));
            builder.setProperty(d.property);
            push.addInfo(builder);
        }
        return push;
    }

    /**
     * 执行天赋逻辑
     *
     * @param heroId
     * @param talentInfo
     * @param talent
     */
    public static void talentProcess(final int heroId, final int talentInfo, final Consumer<TalentConfigData> talent) {
        final HeroConfigData heroConfig = ConfigManager.heroDataBox.findById(heroId);

        final List<Integer> talentList = CalcUtil.getIntList(talentInfo);
        for (int i = 0; i < talentList.size(); i++) {
            final int talentRowIndex = talentList.get(i);
            if (talentRowIndex == 9) {
                continue;
            }
            final int index = i * 3 + talentRowIndex - 1;
            final int talentId = heroConfig.talent.get(index);
            final TalentConfigData tdata = ConfigManager.talentDataBox.findById(talentId);
            if (tdata.talentId <= 20) {
                continue;
            }

            talent.accept(tdata);
        }
    }

    /**
     * 进入战役
     *
     * @param player
     */
    public static void battleEnter(final Player player, final int battleId) {
        final BattleFormationDataBox formationDataBox = ConfigManager.battleFormationDataBox;
        EvilAssert.notNull(formationDataBox.findByCollectId(battleId), "战役不存在");
        ModuleAssert.isFalse(player.getPd().getFightInfoCount() > 0, ErrorEnum.ERR_113);

        final FightStartPush.Builder fightStartPush = FightService.genBattleEnemy(battleId);
        fightStartPush.setManual(ConfigManager.battleInfoDataBox.findById(battleId).manual);

        player.pd.addAllFightInfo(fightStartPush.getInfoList());
        player.pd.setBattleId(battleId);
        player.pd.setManual(fightStartPush.getManual());
        player.send(No.FightStartPush, fightStartPush.buildPartial());
    }


    public static List<Reward> fightReward(Player player, BattleRecord record) {
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

    public static FightRecord.Builder buildFightRecord(final BattleRecord record) {
        final FightRecord.Builder builder = FightRecord.newBuilder();
        for (final HeroRecordData hero : record.getSideAhero()) {
            builder.addSideA(HeroDataRecord.newBuilder()
                    .setId(hero.simple.id)
                    .setHp(hero.simple.hp)
                    .setName(hero.simple.name)
                    .setPos(hero.simple.pos.getIndex())
                    .setType(hero.simple.type)
                    .build());
        }
        for (final HeroRecordData hero : record.getSideBhero()) {
            builder.addSideB(HeroDataRecord.newBuilder()
                    .setId(hero.simple.id)
                    .setHp(hero.simple.hp)
                    .setLevel(hero.simple.level)
                    .setName(hero.simple.name)
                    .setPos(hero.simple.pos.getIndex())
                    .setType(hero.simple.type)
                    .build());
        }

        if (record.getRoundList() != null) {

            for (final Round round : record.getRoundList()) {

                builder.addRound(roundReport(round));
            }

        }
        return builder;

    }

    public static RoundRecord roundReport(Round round) {
        final RoundRecord.Builder rb = RoundRecord.newBuilder();
        for (final game.module.battle.record.Record r : round.getRecordList()) {
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


    public static void endFight(Player player) {
        player.pd.clearFightInfo();
        player.pd.setBattleId(0);
        player.hmBattle = null;
    }
}
