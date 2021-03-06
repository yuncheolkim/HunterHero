package game.module.player;

import com.cloverfew.repository.PlayerRepository;
import game.base.Logs;
import game.base.util.Tuple2;
import game.game.enums.FeatureEnum;
import game.manager.RepositoryManager;
import game.proto.FeatureOpenPush;
import game.proto.NpcShowChangePush;
import game.proto.back.SaveData;
import game.proto.data.NpcShowEnum;
import game.proto.no.No;

import java.io.IOException;
import java.util.Optional;

/**
 * @author Yunzhe.Jin
 * 2021/6/19 13:21
 */
public class PlayerService {

    /**
     * 开始新功能
     *
     * @param player
     * @param featureEnum
     */
    public static void openFeature(Player player, FeatureEnum featureEnum) {
        player.pd.setOpenFeature(player.pd.getOpenFeature() | featureEnum.id);
        featureEnum.openPrepare(player);
        player.send(No.FeatureOpenPush, FeatureOpenPush.newBuilder()
                .setId(featureEnum.index).build());
    }

    /**
     * 是否开始某项功能
     *
     * @param player
     * @param featureEnum
     * @return
     */
    public static boolean isOpenFeature(Player player, FeatureEnum featureEnum) {
        return (player.pd.getOpenFeature() & 1 << featureEnum.index) != 0;
    }

    /**
     * Show or hide a npc
     *
     * @param player
     * @param npcId
     */
    public static void showOrHideNpc(Player player, int npcId, boolean show) {
        int i = 0;
        switch (npcId) {
            case 14://苏离
                i = NpcShowEnum.NPC_SHOW_1_VALUE;
                break;
        }

        if (i == 0) {
            Logs.C.warn("Not found show npc:{}", npcId);
            return;
        }
        player.pd.setShowNpc(player.pd.getShowNpc() | i);

        if (!show) {
            player.pd.setShowNpc((player.pd.getShowNpc() | i) ^ i);
        }

        player.send(No.NpcShowChangePush, NpcShowChangePush.newBuilder()
                .setShowNo(player.pd.getShowNpc())
                .setNpcId(npcId)
                .build());
    }

    /**
     * 持久化数据
     *
     * @param data
     */
    public static void saveData(com.cloverfew.repository.mybatis.Player data) {
        PlayerRepository repo = RepositoryManager.getRepo(PlayerRepository.class);
        repo.update(data);
    }

    public static void insert(com.cloverfew.repository.mybatis.Player data) {
        PlayerRepository repo = RepositoryManager.getRepo(PlayerRepository.class);
        repo.insert(data);
    }

    public static Tuple2<game.proto.back.SaveData.Builder, com.cloverfew.repository.mybatis.Player> load(String account) {
        PlayerRepository repo = RepositoryManager.getRepo(PlayerRepository.class);
        com.cloverfew.repository.mybatis.Player player = repo.findByAccount(account).get();
        try {
            byte[] s = player.getData();
            return new Tuple2<>(SaveData.newBuilder().mergeFrom(s), player);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean hasAccount(String account) {
        PlayerRepository repo = RepositoryManager.getRepo(PlayerRepository.class);
        Optional<com.cloverfew.repository.mybatis.Player> byAccount = repo.findByAccount(account);
        return byAccount.isPresent();
    }
}
