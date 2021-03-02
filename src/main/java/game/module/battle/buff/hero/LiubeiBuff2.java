package game.module.battle.buff.hero;

import game.utils.CalcUtil;
import game.module.battle.Hero;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.DefaultDataBuff;

/**
 * @author Yunzhe.Jin
 * 2021/2/3 18:09
 */
public class LiubeiBuff2 extends DefaultDataBuff {

    public LiubeiBuff2() {
        effectPoint.put(ActionPoint.受到伤害之前, 1);
        id = 300004;
        name = "以德服人";
        data.setInt1(10);
    }


    @Override
    public void process(ActionPoint actionPoint, Hero hero) {
        int maxHp = hero.property.getMaxHp();

        int maxDamageable = CalcUtil.calcRateAdd(maxHp, data.getInt1());
        hero.damageInfo.adjustDamageHp(maxDamageable);

    }
}
