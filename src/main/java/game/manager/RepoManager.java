package game.manager;

import game.repo.PlayerRepo;

/**
 * 持久化管理,数据落地
 *
 * @author Yunzhe.Jin
 * 2021/2/22 17:19
 */
public class RepoManager {

    private PlayerRepo playerRepo = new PlayerRepo();


    public PlayerRepo getPlayerRepo() {
        return playerRepo;
    }
}
