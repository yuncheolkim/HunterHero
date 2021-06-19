package game.module.fight;

import game.base.G;
import game.base.Logs;
import game.config.data.BattleFormationConfigData;
import game.config.data.EnemyConfigData;
import game.config.data.EnemyCountConfigData;
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
                player.D.setFightTime(DateUtils.now() + TimeUnit.MINUTES.toMillis(10));
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
        final List<EnemyConfigData> enemyList = new ArrayList<>();
        for (final Integer enemyAreaId : player.D.getFightAreaList()) {
            final List<EnemyConfigData> enemy = ConfigManager.enemyDataBox.findByCollectId(enemyAreaId);
            if (!enemy.isEmpty()) {
                enemyList.addAll(enemy);
            }
        }

        // count
        final List<EnemyCountConfigData> enemyCountList = new ArrayList<>();
        for (final Integer enemyAreaId : player.D.getFightAreaList()) {
            final List<EnemyCountConfigData> list = ConfigManager.enemyCountDataBox.findByCollectId(enemyAreaId);
            enemyCountList.addAll(list);
        }
        final int count = CalcUtil.weightRandom(enemyCountList).count;
        // hero info
        final List<EnemyConfigData> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            result.add(CalcUtil.weightRandom(enemyList));
        }

        // hero pos
        final List<Integer> pos = RANDOM_8.posList(count);

        final FightStartPush.Builder push = FightStartPush.newBuilder();

        for (int i = 0; i < count; i++) {
            final FightEnemyInfo.Builder builder = FightEnemyInfo.newBuilder();
            final EnemyConfigData d = result.get(i);
            builder.setId(d.enemyId);
            builder.setPos(pos.get(i));
            builder.setLevel(d.level);
            builder.setType(EnemyType.CREATURE);
            builder.setName(G.C.dataMap5.get(d.enemyId).name);
            builder.setProperty(d.property);

            push.addInfo(builder);
        }

        return push.build();
    }

    public static FightStartPush genBattleEnemy(int battleId) {

        List<BattleFormationConfigData> enemyList = ConfigManager.battleFormationDataBox.findByCollectId(battleId);
        final FightStartPush.Builder push = FightStartPush.newBuilder();
        for (BattleFormationConfigData d : enemyList) {

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

}
