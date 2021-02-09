package game.hunter.damage;

/**
 * 计算伤害
 *
 * @author Yunzhe.Jin
 * 2021/1/11 16:31
 */
public interface DamagedProcess {

    /**
     * 计算伤害
     *
     * @return 是否计算后续功能
     */
    boolean process(DamageInfo info);

}
