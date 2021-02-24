package game.base;

import game.manager.*;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 10:35
 */
public class G {
    public static WorkManager W = new WorkManager();

    public static PlayerManager P = new PlayerManager();

    public static GameManager G = new GameManager();

    public static RepoManager R = new RepoManager();

    public static ScheduleManager S = new ScheduleManager();

    public static ConfigManager C = new ConfigManager();
}
