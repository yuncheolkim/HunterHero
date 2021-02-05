package game.hunter.buff.hero;

import game.hunter.CalcUtil;
import game.hunter.Hero;
import game.hunter.action.ActionPoint;
import game.hunter.buff.DefaultDataBuff;

/**
 * 激励
 * 增加攻击力
 * @author Yunzhe.Jin
 * 2021/2/3 18:09
 */
public class CaocaoBuff1 extends DefaultDataBuff {

    public CaocaoBuff1() {
        effectPoint.put(ActionPoint.闪避之后, 1);
        effectPoint.put(ActionPoint.重新计算属性, 1);
        id = 300005;
        name = "奸雄";
        // 每次闪避增加的百分比
        data.setInt2(5);
    }

    @Override
    public void process(ActionPoint actionPoint, Hero hero) {
        if (actionPoint == ActionPoint.闪避之后) {
            data.setInt1(data.getInt1() + data.getInt2());
            hero.property.damage += CalcUtil.calcRateAdd(hero.origin.damage, data.getInt2());
        } else {
            hero.property.damage += CalcUtil.calcRateAdd(hero.origin.damage, data.getInt1());
        }
    }
}
