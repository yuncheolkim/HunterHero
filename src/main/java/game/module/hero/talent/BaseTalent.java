package game.module.hero.talent;

import game.module.hero.calc.IHeroCalc;
import game.proto.data.PlayerHero;

/**
 * @author Yunzhe.Jin
 * 2021/6/19 23:55
 */
public class BaseTalent implements IHeroCalc {

    /**
     * 0:静态
     * 1:动态
     */
    protected int talentType;


    @Override
    public void calc(PlayerHero old, PlayerHero.Builder builder) {
        
    }
}
