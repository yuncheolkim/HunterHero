package game.base;

import game.manager.*;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 10:35
 */
public class G {

    ///////////// Lifecycle
    public static WorkManager W = new WorkManager();
    public static GameManager G = new GameManager();
    public static ScheduleManager S = new ScheduleManager();
    public static ConfigManager C = new ConfigManager();

    ///////////// No Lifecycle
    public static RepoManager R = new RepoManager();
    public static PlayerManager P = new PlayerManager();
    public static EventManager E = new EventManager();


    public static void findException(Exception e) {
        Logs.C.error(e);
        System.exit(-1);
    }
}
