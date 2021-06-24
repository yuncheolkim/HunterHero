package game.module.battle.damage;

import game.base.Logs;
import game.utils.CalcUtil;

/**
 * 受到伤害时计算闪避
 *
 * @author Yunzhe.Jin
 * 2021/1/12 10:47
 */
public class AvoidDamagedProcess implements DamagedProcess {
    @Override
    public boolean process(DamageInfo info) {

        int avoid = info.target.fightingData.getAvoid();
        boolean happened = CalcUtil.happened(info.source.getBattle().getRandom(), avoid, avoid + info.target.fightingData.getAvoidBase());
        if (happened) {
            info.avoid = (true);
            Logs.trace("闪避成功");
            return false;
        }
        return true;
    }
}
