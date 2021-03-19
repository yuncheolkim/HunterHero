package game.module.fight;

import game.base.G;
import game.base.Logs;
import game.config.enmey.EnemyAreaConfigData;
import game.config.enmey.EnemyConfigData;
import game.config.enmey.EnemyCountConfigData;
import game.player.Player;
import game.proto.FightStartPush;
import game.proto.Message;
import game.proto.data.EnemyType;
import game.proto.data.FightEnemyInfo;
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
    public static void checkFight(Player player) {
        if (player.pd.getFightInfoCount() > 0) {
            // 已经在战斗中
            return;
        }

        if (player.D.getFightAreaCount() > 0) {
            long now = DateUtils.now();
            if (player.D.getFightTime() < now) {
                // fight
                FightStartPush fightStartPush = genEnemy(player);
                player.getPd().addAllFightInfo(fightStartPush.getInfoList());

                player.getTransport().send(Message.newBuilder()
                        .setMsgNo(2002)
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
    private static FightStartPush genEnemy(Player player) {

        Logs.C.debug("生成敌人");
        int allWeight = 0;
        List<EnemyConfigData> enemyList = new ArrayList<>();
        for (Integer enemyAreaId : player.D.getFightAreaList()) {
            EnemyAreaConfigData enemy = G.C.enemyInfoMap.get(enemyAreaId);
            enemyList.addAll(enemy.enemyList);
            allWeight += enemy.weightAll;
        }

        // count
        List<EnemyCountConfigData> enemyCountList = new ArrayList<>();
        for (Integer enemyAreaId : player.D.getFightAreaList()) {
            List<EnemyCountConfigData> list = G.C.enemyCountMap.get(enemyAreaId);
            enemyCountList.addAll(list);
        }
        int count = CalcUtil.weightRandom(enemyCountList).count;
        // hero info
        List<EnemyConfigData> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            result.add((EnemyConfigData) CalcUtil.weightRandom(enemyList, allWeight));
        }

        // heor pos
        List<Integer> pos = RANDOM_8.posList(count);

        FightStartPush.Builder push = FightStartPush.newBuilder();

        for (int i = 0; i < count; i++) {
            FightEnemyInfo.Builder builder = FightEnemyInfo.newBuilder();
            EnemyConfigData d = result.get(i);
            builder.setId(d.id);
            builder.setPos(pos.get(i));
            builder.setLevel(d.level);
            builder.setType(EnemyType.CREATURE);
            builder.setName(G.C.dataMap5.get(d.id).name);
            builder.getPropertyBuilder()
                    .setHp(d.hp)
                    .setDamage(d.damage)
                    .setDef(d.def)
                    .setDefBase(d.defBase)
                    .setAvoid(d.avoid)
                    .setAvoidBase(d.avoidBase)
                    .setCritical(d.critical)
                    .setCriticalBase(d.criticalBase)
                    .setCriticalDamage(d.criticalDamage)
                    .setSpeed(d.speed);

            push.addInfo(builder);
        }

        return push.build();
    }

}
