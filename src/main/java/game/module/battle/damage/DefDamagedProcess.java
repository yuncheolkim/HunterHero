package game.module.battle.damage;

import game.module.battle.Hero;
import game.module.battle.HeroData;

/**
 * 受到伤害-计算护甲
 * @author Yunzhe.Jin
 * 2021/1/12 10:49
 */
public class DefDamagedProcess implements DamagedProcess {

    private int rateBase = 500;

    @Override
    public boolean process(DamageInfo info) {

        Hero target = info.target;
        HeroData fightingData = target.fightingData;
        int rate = fightingData.getDef() * 100 / (fightingData.getDef() + rateBase);

        if( rate > 0){
            info.reduceDamage(rate);
        }

        return true;
    }
}
