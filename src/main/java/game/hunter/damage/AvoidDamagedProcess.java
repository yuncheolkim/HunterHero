package game.hunter.damage;

import game.hunter.CalcUtil;
import game.hunter.Hero;

/**
 * 受到伤害时计算闪避
 *
 * @author Yunzhe.Jin
 * 2021/1/12 10:47
 */
public class AvoidDamagedProcess implements DamagedProcess {
    @Override
    public boolean process(Hero hero) {
        DamageInfo info = hero.getBattle().getDamageInfo();

        int avoid = hero.getFinalData().getAvoid();
        boolean happened = CalcUtil.happened(hero.getBattle().getRandom(), avoid, avoid + 200);
        if (happened) {
            info.setAvoid(true);
            return false;
        }
        return true;
    }
}
