package game.module.hero.calc;

import game.proto.data.PlayerHero;

/**
 * 计算英雄属性
 * @author Yunzhe.Jin
 * 2021/3/8 15:14
 */
public interface IHeroCalc {

    void calc(PlayerHero old, PlayerHero.Builder builder);

}
