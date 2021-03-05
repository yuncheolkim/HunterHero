package game.module.player;

import game.base.G;
import game.base.Logs;
import game.config.enmey.EnemyAreaConfigData;
import game.config.enmey.EnemyConfigData;
import game.config.enmey.EnemyCountConfigData;
import game.player.Player;
import game.proto.*;
import game.proto.data.EnemyType;
import game.proto.data.FightEnemyInfo;
import game.utils.CalcUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static game.module.battle.PosGen.RANDOM_8;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 16:00
 */
public class PlayerHandler {
    public static void heartbeat(Player player, HeartbeatReq o) {
        player.getTransport().send(4, HeartbeatRes.getDefaultInstance());
    }

    /**
     * 起名
     * @param player
     * @param o
     * @return
     */
    public static void createName(Player player, PlayerCreateNameReq o) {

        player.getPd().setName(o.getName());
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 玩家定时器
     * 每5秒执行一次
     * @param player
     * @param o
     * @return
     */
    public static void tick(Player player, Empty o) {
        Logs.C.info("定时器:{}", player.getPid());

        // 体力恢复
        recoverPower(player);

        // 检查战斗
        checkFight(player);

    }

    /**
     * 检查战斗
     * @param player
     */
    private static void checkFight(Player player) {

        if (G.C.enemyInfoMap.containsKey(player.getPd().getSceneData().getId()) &&
                player.D.getFightAreaCount() > 0) {
            long now = System.currentTimeMillis();
            if (player.nextFightTime > now) {
                // fight
                FightStartPush fightStartPush = genEnemy(player);
                player.getPd().addAllFightInfo(fightStartPush.getInfoList());

                player.getTransport().send(Message.newBuilder()
                        .setMsgNo(2002)
                        .setBody(fightStartPush.toByteString())
                        .build());
            }
            player.nextFightTime = now + CalcUtil.DEFAULT_RANDOM.nextInt(15_000) + 5_000;
        } else {
            player.nextFightTime = 0;
        }
    }

    /**
     * 生成小怪
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
        int count = CalcUtil.weightRandom(enemyCountList).weight();
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


    /**
     * 恢复体力
     */
    public static void recoverPower(Player player) {

        long now = System.currentTimeMillis();

        long second = TimeUnit.MILLISECONDS.toSeconds(now - player.getPowerRecoverTime());
        int powerRecoverSecond = player.getPd().getResourceBuilder().getPowerRecoverSecond();
        if (second >= powerRecoverSecond) {
            long recover = second / powerRecoverSecond;
            long power = player.getPd().getResourceBuilder().getPower() + recover;
            if (power > player.getPd().getResourceBuilder().getMaxPower()) {
                power = player.getPd().getResourceBuilder().getMaxPower();
            }
            player.getPd().getResourceBuilder().setPower((int) power);
            player.setPowerRecoverTime(player.getPowerRecoverTime() + 1000L * recover * powerRecoverSecond);
        }
    }


    /**
     * 定时存db
     * @param player
     * @param o
     * @return
     */
    public static void dataFlush(Player player, Empty o) {
        Logs.C.info("保存玩家数据:{}", player.getPid());
        player.saveData();
    }
}
