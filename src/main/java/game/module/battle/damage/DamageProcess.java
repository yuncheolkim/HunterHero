package game.module.battle.damage;

import game.module.battle.Hero;

/**
 * 计算伤害
 *
 * @author Yunzhe.Jin
 * 2021/1/11 16:31
 */
public interface DamageProcess {

    /**
     * 计算伤害
     *
     * @param hero
     *
     * @return 是否计算后续功能
     */
    boolean process(Hero hero);

}
