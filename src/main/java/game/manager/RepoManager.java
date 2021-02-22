package game.manager;

import game.repo.PlayerRepo;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 17:19
 */
public class RepoManager {

    private PlayerRepo playerRepo = new PlayerRepo();


    public PlayerRepo getPlayerRepo() {
        return playerRepo;
    }
}
