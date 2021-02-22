package game.repo;

import game.module.data.PlayerData;
import game.utils.FileUtils;
import game.utils.JsonUtil;

import java.io.IOException;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 17:19
 */
public class PlayerRepo extends FileRepo {

    public PlayerData find(String account) {
        try {
            String s = FileUtils.readFile("data/" + account);
            return JsonUtil.fromJsonString(s, PlayerData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public void save(PlayerData data) {
        try {
            FileUtils.writeFile("data/" + data.account, JsonUtil.toJsonString(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
