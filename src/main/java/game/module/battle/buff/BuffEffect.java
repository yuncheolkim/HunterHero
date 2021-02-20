package game.module.battle.buff;

import game.module.battle.Hero;

/**
 * buff的效果
 *
 * @author Yunzhe.Jin
 * 2021/1/8 15:44
 */
public interface BuffEffect {

    /**
     * @param hero
     * @param buff
     *
     * @return 是否继续处理
     */
    default boolean doEffect(Hero hero, Buff buff) {
        return true;
    }


}
