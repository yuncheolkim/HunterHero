package game.module.fight;

import game.base.G;
import game.game.scene.GameScene;
import game.module.battle.Battle;
import game.module.battle.Side;
import game.module.battle.battle.AutoBattle;
import game.module.battle.record.BattleRecord;
import game.module.fight.data.FightCancelAtPrepare;
import game.module.fight.data.FightFormation;
import game.proto.back.LadderResult;
import game.proto.data.FightRecord;
import game.proto.data.FightType;
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
public class LadderFightScene extends GameScene {
    /**
     * 已准备的玩家
     * key: match id
     */
    private Map<Long, Long> prepareMap = new HashMap<>();

    /**
     * 取消的玩家
     * key: match id
     */
    private Map<Long, Long> cancelMap = new HashMap<>();

    /**
     * key : uid
     */
    private Map<Long, FightFormation> formationMap = new HashMap<>();

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
        final long id = msg.id;
        if (prepareMap.containsKey(id)) {
            // 对方已经准备 通知对方结束匹配
            G.sendToPlayer(prepareMap.get(id), No.LadderCancel.getNumber());
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

        final long id = msg.id;
        if (prepareMap.get(id) != null) {
            // fight
            fight(formationMap.get(prepareMap.get(id)), msg);
        } else if (cancelMap.get(id) != null) {
            cancelMap.remove(id);
            // Cancel
            G.sendToPlayer(msg.uid, No.LadderCancel.getNumber());

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

        prepareMap.remove(a.id);
        prepareMap.remove(b.id);

        final Battle battle = new AutoBattle();
        battle.setFightType(FightType.F_LADDER_SINGLE);

        a.heroList.forEach(hero -> {
            hero.setSide(a.side);
            hero.setBattle(battle);
            if (hero.getSide() == Side.A) {
                hero.setSpeed(1);
            } else {
                hero.setSpeed(2);
            }
            battle.addHero(hero);
        });
        b.heroList.forEach(hero -> {
            hero.setSide(b.side);
            hero.setBattle(battle);
            if (hero.getSide() == Side.A) {
                hero.setSpeed(1);
            } else {
                hero.setSpeed(2);
            }
            battle.addHero(hero);
        });

        final BattleRecord record = battle.start();

        final FightRecord.Builder result = buildFightRecord(record);

        if (a.side == record.getWinSide()) {
            result.setWinUid(a.uid);
        } else {
            result.setWinUid(b.uid);
        }
        LadderResult r = LadderResult.newBuilder().setType(1)
                .setRecord(result)
                .build();


        G.sendToPlayer(a.uid, No.LadderResult.getNumber(), r);
        G.sendToPlayer(b.uid, No.LadderResult.getNumber(), r);
    }
}
