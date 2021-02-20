package game.module.battle.status;

/**
 * @author Yunzhe.Jin
 * 2021/1/11 14:40
 */
public interface HeroStatusChangeListener {

    /**
     * 血量变化
     * @param info
     */
    default void changHp(HealthChangeInfo info){}
}
