package game.module.fight;

import game.base.Logs;
import game.config.base.WeightData;
import game.config.data.*;
import game.manager.ConfigManager;
import game.player.Player;
import game.proto.FightStartPush;
import game.proto.Message;
import game.proto.back.FightType;
import game.proto.data.EnemyType;
import game.proto.data.FightEnemyInfo;
import game.proto.no.No;
import game.utils.CalcUtil;
import game.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static game.module.battle.PosGen.RANDOM_8;

/**
 * @author Yunzhe.Jin
 * 2021/3/19 20:20
 */
public class FightService {

    /**
     * 检查战斗
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
                final FightStartPush fightStartPush = genEnemy(player);
                player.getPd().addAllFightInfo(fightStartPush.getInfoList());

                player.getTransport().send(Message.newBuilder()
                        .setMsgNo(No.FightStartPush_VALUE)
                        .setBody(fightStartPush.toByteString())
                        .build());
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
    private static FightStartPush genEnemy(final Player player) {

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

        return push.build();
    }

    /**
     * 战役
     *
     * @param battleId
     * @return
     */
    public static FightStartPush genBattleEnemy(final int battleId) {

        final List<BattleFormationConfigData> enemyList = ConfigManager.battleFormationDataBox.findByCollectId(battleId);
        final FightStartPush.Builder push = FightStartPush.newBuilder();
        for (final BattleFormationConfigData d : enemyList) {

            final FightEnemyInfo.Builder builder = FightEnemyInfo.newBuilder();
            builder.setId(d.enemyId);
            builder.setPos(d.pos);
            builder.setLevel(d.level);
            builder.setType(EnemyType.CREATURE);
            builder.setName(d.name);
            builder.setProperty(d.property);
            push.addInfo(builder);
        }
        return push.build();
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
}
