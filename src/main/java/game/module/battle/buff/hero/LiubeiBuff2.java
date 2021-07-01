package game.module.battle.buff.hero;

import game.module.battle.Hero;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.DefaultDataBuff;
import game.utils.CalcUtil;

/**
 * @author Yunzhe.Jin
 * 2021/2/3 18:09
 */
public class LiubeiBuff2 extends DefaultDataBuff {

    public LiubeiBuff2() {
        id = 300004;
        effectPoint.put(ActionPoint.受到伤害之前, 1);
        name = "以德服人";
        data.setInt1(10);
    }


    @Override
    public void process0(final ActionPoint actionPoint, final Hero hero) {
        final int maxHp = hero.property.getMaxHp();

        final int maxDamageable = CalcUtil.add100(maxHp, data.getInt1());
        hero.damageInfo.adjustDamageHp(maxDamageable);

    }
}
