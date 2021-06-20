package game.module.hero.talent;

import game.proto.data.PlayerHero;

/**
 * @author Yunzhe.Jin
 * 2021/6/20 0:09
 */
public interface ITalent {
    void process(PlayerHero old, PlayerHero.Builder builder);
}
