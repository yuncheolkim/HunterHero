package game.module.battle.buff.hero;

import game.module.battle.BattleConstant;
import game.module.battle.Hero;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.Buff;
import game.module.battle.buff.BuffMergeType;
import game.utils.CalcUtil;

/**
 * 冰冻
 * <p>
 * 0:护甲降低
 * 1:伤害加深
 *
 * @author Yunzhe.Jin
 * 2021/7/1 12:44
 */
public class LusuBuff1 extends Buff {


    public LusuBuff1() {
        super(BattleConstant.buff_lusu_1);
        buffMergeType = BuffMergeType.MERGE;
        effectPoint.put(ActionPoint.被攻击之前, 1);
        init();
    }

    @Override
    public void process0(final ActionPoint actionPoint, final Hero hero) {
        if (actionPoint == ActionPoint.被攻击之前) {
            // 护甲降低
            final int int1 = data[0];
            // 伤害加深
            final int int2 = data[1];

            if (int1 > 0) {
                hero.fightingData.setDef(CalcUtil.add100(hero.fightingData.getDef(), int1));
            }


            if (int2 > 0) {
                final int harmRate = hero.fightingData.getHarmRate();
                hero.fightingData.setHarmRate(harmRate + int2);
            }
        }
    }

    public void setDefRate(int v) {
        data[0] = v;
    }

    public void setHarmRate(int v) {
        data[1] = v;

    }
}

