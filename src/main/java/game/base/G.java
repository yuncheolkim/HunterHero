package game.base;

import game.manager.GameManager;
import game.manager.PlayerManager;
import game.manager.RepoManager;
import game.manager.WorkManager;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 10:35
 */
public class G {
    public static WorkManager W = new WorkManager();

    public static PlayerManager P = new PlayerManager();

    public static GameManager G = new GameManager();

    public static RepoManager R = new RepoManager();

}
