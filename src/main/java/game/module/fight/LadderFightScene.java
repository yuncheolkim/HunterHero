package game.module.fight;

import game.base.G;
import game.config.data.LadderSingleConfigData;
import game.game.scene.Scene;
import game.manager.ConfigManager;
import game.module.battle.Battle;
import game.module.battle.Pos;
import game.module.battle.Side;
import game.module.battle.battle.AutoBattle;
import game.module.battle.record.BattleRecord;
import game.module.fight.data.FightCancelAtPrepare;
import game.module.fight.data.FightFormation;
import game.module.ladder.LadderService;
import game.proto.back.LadderResult;
import game.proto.data.FightRecord;
import game.proto.data.LadderSinglePlayer;
import game.proto.no.No;

import java.util.HashMap;
import java.util.Map;

import static game.module.fight.FightService.buildFightRecord;

/**
 * 玩家之间的战斗执行
 *
 * @author Yunzhe.Jin
 * 2021/8/28 21:25
 */
public class LadderFightScene extends Scene {
    /**
     * 已准备的玩家
     * key: match id
     */
    private final Map<String, Long> prepareMap = new HashMap<>();

    /**
     * 取消的玩家
     * key: match id
     */
    private final Map<String, Long> cancelMap = new HashMap<>();

    /**
     * key : uid
     */
    private final Map<Long, FightFormation> formationMap = new HashMap<>();

    @Override
    protected void process(Object msg) {

        if (msg instanceof FightCancelAtPrepare) {

            cancel((FightCancelAtPrepare) msg);

        } else if (msg instanceof FightFormation) {

            prepare((FightFormation) msg);

        }
    }

    /**
     * 取消匹配
     *
     * @param msg
     */
    private void cancel(FightCancelAtPrepare msg) {
        String id = msg.uid + "-" + msg.matchId;
        if (prepareMap.containsKey(id)) {
            // 对方已经准备 通知对方结束匹配
            G.sendToPlayer(prepareMap.get(id), No.LadderCancelInner.getNumber());
        } else if (!cancelMap.containsKey(id)) {
            // 对方没有准备
            cancelMap.put(id, msg.uid);
        } else {
            // 对方先取消
            cancelMap.remove(id);
        }

    }

    /**
     * 准备战斗
     *
     * @param msg
     */
    private void prepare(FightFormation msg) {

        String id = msg.uid + "-" + msg.matchId;
        if (prepareMap.get(id) != null) {
            // fight
            fight(formationMap.get(prepareMap.get(id)), msg);
        } else if (cancelMap.get(id) != null) {
            cancelMap.remove(id);
            // Cancel
            G.sendToPlayer(msg.uid, No.LadderCancelInner.getNumber());
        } else {
            prepareMap.put(id, msg.uid);
            formationMap.put(msg.uid, msg);
        }

    }

    /**
     * 战斗
     *
     * @param fightFormation
     * @param msg
     */
    private void fight(FightFormation a, FightFormation b) {
        String aid = a.uid + "-" + a.matchId;
        String bid = b.uid + "-" + b.matchId;

        prepareMap.remove(aid);
        prepareMap.remove(bid);

        final Battle battle = new AutoBattle();
        battle.setFightType(a.battleType);

        a.heroList.forEach(hero -> {
            hero.setBattle(battle);
            if (hero.getSide() == Side.A) {// 先手
                hero.setSpeed(hero.getSpeed() * 2 - 1);
            } else {
                hero.setSpeed(hero.getSpeed() * 2);
                hero.setPos(Pos.from(hero.getPos().getIndex() + 16));
            }
            battle.addHero(hero);
        });
        b.heroList.forEach(hero -> {
            hero.setBattle(battle);
            if (hero.getSide() == Side.A) {
                hero.setSpeed(hero.getSpeed() * 2 - 1);
            } else {
                hero.setSpeed(hero.getSpeed() * 2);
                hero.setPos(Pos.from(hero.getPos().getIndex() + 16));
            }
            battle.addHero(hero);
        });

        final BattleRecord record = battle.start();

        final FightRecord.Builder result = buildFightRecord(record);

        LadderSingleConfigData scoreA = ConfigManager.ladderSingleDataBox.findScore(a.score);
        LadderSingleConfigData scoreB = ConfigManager.ladderSingleDataBox.findScore(b.score);

        int k = (scoreA.k + scoreB.k) / 2;

        int addedScore;
        LadderResult.Builder ra = LadderResult.newBuilder().setType(1);
        LadderResult.Builder rb = LadderResult.newBuilder().setType(1);

        if (a.side == record.getWinSide()) {
            addedScore = LadderService.calcScoreWinA(a.score, b.score, k);
            result.setWinUid(a.uid);
            ra.setScore(addedScore);
            rb.setScore(-addedScore);
        } else {
            addedScore = LadderService.calcScoreWinB(a.score, b.score, k);
            result.setWinUid(b.uid);
            ra.setScore(-addedScore);
            rb.setScore(addedScore);
        }

        ra.setRecord(result);
        rb.setRecord(result);

        // todo
        long firstUid = a.side == Side.A ? a.uid : b.uid;
        ra.setFirstUid(firstUid);
        rb.setFirstUid(firstUid);

        ra.setP1(LadderSinglePlayer.newBuilder()
                .setUid(a.uid)
                .setHeroId(a.heroList.get(0).getId()).setName(a.userName).build());
        ra.setP2(LadderSinglePlayer.newBuilder()
                .setUid(b.uid)
                .setHeroId(b.heroList.get(0).getId()).setName(b.userName).build());

        rb.setP1(ra.getP1());
        rb.setP2(ra.getP2());

        G.sendToPlayer(a.uid, No.LadderResultInner.getNumber(), ra.buildPartial());
        if (a.uid != b.uid) {// todo 用于测试
            G.sendToPlayer(b.uid, No.LadderResultInner.getNumber(), rb.buildPartial());
        }
    }
}
