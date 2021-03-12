package game.module.player;

import game.base.G;
import game.base.Logs;
import game.config.enmey.EnemyAreaConfigData;
import game.config.enmey.EnemyConfigData;
import game.config.enmey.EnemyCountConfigData;
import game.game.ResourceSourceEnum;
import game.player.Player;
import game.proto.*;
import game.proto.back.MsgNo;
import game.proto.data.EnemyType;
import game.proto.data.FightEnemyInfo;
import game.proto.data.PlayerHero;
import game.proto.data.Resource;
import game.utils.CalcUtil;
import game.utils.DateUtils;

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
        player.getTransport().send(MsgNo.heartbeat_VALUE, HeartbeatRes.getDefaultInstance());
    }

    /**
     * 起名
     *
     * @param player
     * @param o
     * @return
     */
    public static void createName(Player player, PlayerCreateNameReq o) {

        player.getPd().setName(o.getName());
        player.getTransport().send(3, Empty.getDefaultInstance());

    }

    /**
     * 更新英雄属性
     *
     * @param player
     * @param hero
     */
    public static void updateHero(Player player, PlayerHero hero) {
        player.getPd().putHero(hero.getId(), hero);
        // Push
        player.getTransport().send(MsgNo.hero_change_VALUE, HeroChangePush.newBuilder().setHero(hero).build());
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 玩家定时器
     * 每5秒执行一次
     *
     * @param player
     * @param o
     * @return
     */
    public static void tick(Player player) {
        Logs.C.info("定时器:{}", player.getPid());

        // 体力恢复
        recoverPower(player);

        // 检查战斗
        checkFight(player);

    }

    /**
     * 检查战斗
     *
     * @param player
     */
    private static void checkFight(Player player) {

        if (player.D.getFightAreaCount() > 0) {
            long now = DateUtils.now();
            if (player.nextFightTime < now) {
                // fight
                FightStartPush fightStartPush = genEnemy(player);
                player.getPd().addAllFightInfo(fightStartPush.getInfoList());

                player.getTransport().send(Message.newBuilder()
                        .setMsgNo(2002)
                        .setBody(fightStartPush.toByteString())
                        .build());
                // 选择英雄时间
                player.nextFightTime = DateUtils.now() + TimeUnit.MINUTES.toMillis(10);
            }
        } else {
            player.nextFightTime = 0;
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


    /**
     * 恢复体力
     */
    public static void recoverPower(Player player) {

        long now = System.currentTimeMillis();

        long second = TimeUnit.MILLISECONDS.toSeconds(now - player.getPowerRecoverTime());
        Resource.Builder resourceBuilder = player.getPd().getResourceBuilder();
        int powerRecoverSecond = resourceBuilder.getPowerRecoverSecond();
        if (second >= powerRecoverSecond) {
            long recover = second / powerRecoverSecond;
            player.addPower(recover, ResourceSourceEnum.自动恢复);
            player.setPowerRecoverTime(player.getPowerRecoverTime() + 1000L * recover * powerRecoverSecond);
        }
    }


    /**
     * 定时存db
     *
     * @param player
     * @param o
     * @return
     */
    public static void dataFlush(Player player, Empty o) {
        Logs.C.info("保存玩家数据:{}", player.getPid());
        player.saveData();
    }
}
