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
    public boolean process(DamageInfo info) {

        int avoid = info.target.property.getAvoid();
        boolean happened = CalcUtil.happened(info.source.getBattle().getRandom(), avoid, avoid + 200);
        if (happened) {
            info.avoid = (true);
            return false;
        }
        return true;
    }
}
