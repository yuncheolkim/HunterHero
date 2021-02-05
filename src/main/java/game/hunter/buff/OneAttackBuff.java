package game.hunter.buff;

import game.hunter.Hero;
import game.hunter.action.ActionPoint;
import game.hunter.buff.data.OneAttackBuffData;
import game.hunter.buff.effect.DamageRate;
import game.hunter.record.BuffData;

/**
 * 叠加攻击buff
 *
 * @author Yunzhe.Jio
 * 2021/1/8 15:53
 */
public class OneAttackBuff extends Buff {
    private OneAttackBuffData buffData = new OneAttackBuffData();

    public Hero target;

    public OneAttackBuff(Hero t) {
        effects.add(new BuffEffect() {
            @Override
            public boolean doEffect(Hero hero, Buff buff) {
                return target != null && target.isAlive();
            }
        });
        effects.add(new DamageRate());
        effectPoint.put(ActionPoint.重新计算属性, 1);
        buffType = BuffType.BUFF;
        buffMergeType = BuffMergeType.MERGE;
        target = t;
        id = 300002;
        initRound(2);
    }

    @Override
    public ActionPoint reducePoint() {
        return ActionPoint.出手后;
    }

    @Override
    public IBuffVal buffVal() {
        return buffData;
    }

    @Override
    public BuffMergeType calcBuffMergeType(Buff addBuf) {
        if (((OneAttackBuff) addBuf).target != target) {
            return BuffMergeType.REPLACE;
        }
        return BuffMergeType.MERGE;
    }

    @Override
    public String name() {
        return "叠加攻击buff";
    }

    @Override
    public BuffData buffData() {
        BuffData data = super.buffData();
        data.i1 = buffData.i1();
        data.i2 = buffData.i2();
        return data;

    }
}
