package game.module.battle.buff;

import game.module.battle.Hero;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.data.OneAttackBuffData;
import game.module.battle.buff.effect.DamageRate;
import game.module.battle.record.BuffData;

/**
 * 叠加攻击buff
 *
 * @author Yunzhe.Jio
 * 2021/1/8 15:53
 */
public class OneAttackBuff extends Buff {
    private final OneAttackBuffData buffData;

    public Hero target;

    public OneAttackBuff(final Hero t, OneAttackBuffData data) {
        effects.add(new BuffEffect() {
            @Override
            public boolean doEffect(final Hero hero, final Buff buff) {
                return target != null && target.isAlive();
            }
        });
        effects.add(new DamageRate());
        effectPoint.put(ActionPoint.重新计算属性, 1);
        buffType = BuffType.BUFF;
        buffMergeType = BuffMergeType.MERGE;
        target = t;
        id = 300002;
        buffData = data;
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
    public BuffMergeType calcBuffMergeType(final Buff addBuf) {
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
        final BuffData data = super.buffData();
        data.i1 = buffData.i1();
        data.i2 = buffData.i2();
        return data;

    }
}
