package game.module.battle.buff.hero;

import game.module.battle.BattleConstant;
import game.module.battle.Hero;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.BuffMergeType;
import game.module.battle.buff.DefaultDataBuff;

/**
 * @author Yunzhe.Jin
 * 2021/7/1 12:44
 */
public class LusuBuff1 extends DefaultDataBuff {


    public LusuBuff1() {
        id = BattleConstant.buff_lusu_1;
        buffMergeType = BuffMergeType.MERGE;
        effectPoint.put(ActionPoint.被攻击之前, 1);
        init();
    }

    @Override
    public void process(ActionPoint actionPoint, Hero hero) {
        if (actionPoint == ActionPoint.被攻击之前) {
            // 护甲降低
            int int1 = data.getInt1();

            // 伤害加深
            int int2 = data.getInt2();


        }
    }
}
