package game.module.fight;

import game.base.G;
import game.game.scene.GameScene;
import game.module.fight.data.FightCancelAtPrepare;
import game.module.fight.data.FightFormation;
import game.proto.no.No;

import java.util.HashMap;
import java.util.Map;

/**
 * 玩家之间的战斗执行
 *
 * @author Yunzhe.Jin
 * 2021/8/28 21:25
 */
public class LadderFightScene extends GameScene {
    /**
     * 已准备的玩家
     */
    private Map<Long, Long> prepareMap = new HashMap<>();

    /**
     * 取消的玩家
     */
    private Map<Long, Long> cancelMap = new HashMap<>();

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
        formationMap.get(a.uid);
        formationMap.get(b.uid);
        // todo fight

    }
}
