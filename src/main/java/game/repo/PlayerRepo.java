package game.repo;

import game.proto.data.PlayerData;
import game.utils.FileUtils;

import java.io.IOException;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 17:19
 */
public class PlayerRepo extends FileRepo {

    public boolean has(String account) {
        String path = "data/" + account;
        return FileUtils.hasFile(path);
    }

    public PlayerData.Builder load(String account) {
        try {
            String path = "data/" + account;
            if (!FileUtils.hasFile(path)) {
                return null;
            }
            byte[] s = FileUtils.readByteFile(path);
            return PlayerData.newBuilder().mergeFrom(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public void save(PlayerData data) {
        try {
            FileUtils.writeByteFile("data/" + data.getAccount(), data.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
