package game.module.fight;

import game.base.G;
import game.config.DataConfigData;
import game.game.ResourceEnum;
import game.module.battle.*;
import game.module.battle.hero.creature.CreatureTarget;
import game.module.battle.record.BattleRecord;
import game.module.battle.record.HeroRecordData;
import game.module.battle.record.HeroRecordSimple;
import game.module.battle.record.Record;
import game.module.event.ResourceSourceEnum;
import game.module.event.handler.KillEvent;
import game.player.Player;
import game.proto.Empty;
import game.proto.FightRecord;
import game.proto.FightStartReq;
import game.proto.back.MsgNo;
import game.proto.data.*;
import game.utils.CalcUtil;
import game.utils.DateUtils;

import java.util.concurrent.TimeUnit;

/**
 * 战斗相关入口
 *
 * @author Yunzhe.Jin
 * 2021/2/25 10:04
 */
public class FightHandler {

    /**
     * 战斗开始
     *
     * @param player
     * @param req
     * @return
     */
    public static void fight(Player player, FightStartReq req) {
        if (player.getPd().getFightInfoCount() == 0) {
            return;
        }
        // 观看战斗设定为10分钟
        player.nextFightTime = DateUtils.now() + TimeUnit.MINUTES.toMillis(10);

        Battle battle = new Battle();
        // enemy
        for (FightEnemyInfo enemy : player.getPd().getFightInfoList()) {
            CreatureTarget fightEnemy = HeroFactory.createFightEnemy(enemy);
            fightEnemy.setSide(Side.B);
            fightEnemy.setPos(Pos.from(enemy.getPos()));
            fightEnemy.init();
            fightEnemy.setBattle(battle);
            battle.getSideBhero().add(fightEnemy);
        }

        // player
        for (FightHeroPos fightHeroPos : req.getPosList()) {
            PlayerHero playerHero = player.getPd().getHeroMap().get(fightHeroPos.getHeroId());
            if (playerHero == null) {
                return;
            }
            Hero hero = HeroFactory.createPlayerHero(player, playerHero);
            hero.setSide(Side.A);
            hero.setPos(Pos.from(fightHeroPos.getPos()));
            hero.init();
            hero.setBattle(battle);

            battle.getSideAhero().add(hero);
        }

        BattleRecord record = battle.start();

        FightRecord.Builder result = buildFightRecord(record);
        result.setWin(record.getWinSide() == Side.A);
        if (result.getWin()) {
            int exp = 0;
            int gold = 0;

            // 杀敌
            for (HeroRecordData sideBhero : record.getSideBhero()) {
                G.E.firePlayerEvent(player, new KillEvent(sideBhero.simple.id));
                DataConfigData dataConfigData = G.C.dataMap9.get(sideBhero.simple.level);
                exp += dataConfigData.monsterExp;
                gold += CalcUtil.random(dataConfigData.min, dataConfigData.max);
            }
            // 奖励

            if (gold > 0) {
                result.addReward(Reward.newBuilder()
                        .setHeroId(0)
                        .setRewardId(ResourceEnum.GOLD.id)
                        .setCount(gold)
                        .build());

                player.addGold(gold, ResourceSourceEnum.打怪);
            }

            // Add player exp
            player.addPlayerExp(exp, ResourceSourceEnum.打怪);
            result.addReward(Reward.newBuilder()
                    .setHeroId(0)
                    .setRewardId(ResourceEnum.EXP.id)
                    .setCount(exp)
                    .build());
            // Add hero exp
            for (HeroRecordData sideAhero : record.getSideAhero()) {
                player.addHeroExp(sideAhero.simple.id, exp, ResourceSourceEnum.打怪);
                result.addReward(Reward.newBuilder()
                        .setHeroId(sideAhero.simple.id)
                        .setRewardId(ResourceEnum.EXP.id)
                        .setCount(exp)
                        .build());
            }

        }
        player.getTransport().send(MsgNo.fight_start_VALUE, result.build());

    }

    private static FightRecord.Builder buildFightRecord(BattleRecord record) {
        FightRecord.Builder builder = FightRecord.newBuilder();
        for (HeroRecordData hero : record.getSideAhero()) {
            builder.addSideA(HeroDataRecord.newBuilder()
                    .setId(hero.simple.id)
                    .setHp(hero.simple.hp)
                    .setName(hero.simple.name)
                    .setPos(hero.simple.pos.getIndex())
                    .build());
        }
        for (HeroRecordData hero : record.getSideBhero()) {
            builder.addSideB(HeroDataRecord.newBuilder()
                    .setId(hero.simple.id)
                    .setHp(hero.simple.hp)
                    .setName(hero.simple.name)
                    .setPos(hero.simple.pos.getIndex())
                    .build());
        }

        for (Round round : record.getRoundList()) {
            RoundRecord.Builder rb = RoundRecord.newBuilder();
            rb.setRound(round.getRoundCount());
            for (Record r : round.getRecordList()) {
                game.proto.data.Record.Builder re = game.proto.data.Record.newBuilder();
                re.setType(r.type);
                re.setId(r.id);
                re.setValue(r.value);
                re.setPos(r.hero.pos.getIndex());
                if (r.damageType != null) {
                    re.setDamageType(r.damageType);
                }
                if (r.actionPoint != null) {
                    re.setActionPoint(r.actionPoint.name());
                }
                if (r.hero != null) {
                    re.setHeroId(r.hero.id);
                }
                if (r.target != null) {
                    for (HeroRecordSimple heroRecordSimple : r.target) {
                        re.addTarget(heroRecordSimple.pos.getIndex());
                    }
                }
                if (r.buffData != null) {
                    re.getBuffRecordBuilder().setBuffId(r.buffData.buffId);
                    re.getBuffRecordBuilder().setRound(r.buffData.round);
                    re.getBuffRecordBuilder().setRemainRound(r.buffData.remainRound);
                    re.getBuffRecordBuilder().setI1(r.buffData.i1);
                    re.getBuffRecordBuilder().setI2(r.buffData.i2);
                    re.getBuffRecordBuilder().setI3(r.buffData.i3);
                    re.getBuffRecordBuilder().setI4(r.buffData.i4);
                    re.getBuffRecordBuilder().setI5(r.buffData.i5);
                    re.getBuffRecordBuilder().setF1(r.buffData.f1);
                    re.getBuffRecordBuilder().setF2(r.buffData.f2);
                    re.getBuffRecordBuilder().setF3(r.buffData.f3);
                    re.getBuffRecordBuilder().setF4(r.buffData.f4);
                    re.getBuffRecordBuilder().setF5(r.buffData.f5);
                }
                rb.addRecord(re.build());
            }

            builder.addRound(rb.build());
        }

        return builder;

    }

    /**
     * 结束战斗
     *
     * @param player
     * @param req
     */
    public static void endFight(Player player, Empty req) {
        player.getPd().clearFightInfo();
        if (player.D.getFightAreaCount() > 0) {
            player.nextFightTime = DateUtils.now() + CalcUtil.random(5000, 20000);
        }
    }
}
