package game.module.battle.buff.hero;

import game.module.battle.CalcUtil;
import game.module.battle.Hero;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.Buff;
import game.module.battle.buff.IBuffVal;
import game.module.battle.damage.DamageInfo;

/**
 * @author Yunzhe.Jin
 * 2021/2/1 15:13
 */
public class ZhangfeiBuff1 extends Buff {
    public int critical = 50;

    public int criticalDamage = 50;

    public ZhangfeiBuff1() {

        effectPoint.put(ActionPoint.攻击方计算伤害前, 1);
        effectPoint.put(ActionPoint.攻击方计算伤害后, 1);
        id = 300001;
        initRound(2);
    }

    @Override
    public void process(ActionPoint actionPoint, Hero hero) {

        DamageInfo damageInfo = hero.damageInfo;
        if (actionPoint == ActionPoint.攻击方计算伤害前) {
            // 减少对手的暴击率
            int critical = damageInfo.source.fightingData.getCritical();
            critical -= CalcUtil.calcRateAdd(critical, this.critical);
            damageInfo.source.fightingData.setCritical(critical);
        } else {
            if (hero.damageInfo.sourceCriticalDamage != 0) {
                hero.damageInfo.sourceCriticalDamage -= CalcUtil.calcRateAdd(hero.damageInfo.sourceCriticalDamage, this.criticalDamage);
            }
        }
    }

    @Override
    public IBuffVal buffVal() {
        return new IBuffVal() {
            @Override
            public int i1() {
                return critical;
            }

            @Override
            public int i2() {
                return criticalDamage;
            }

            @Override
            public void merge(IBuffVal from) {

            }
        };
    }
}
