package game.manager;

import game.player.Player;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * 玩家信息管理
 *
 * @author Yunzhe.Jin
 * 2021/2/20 11:10
 */
public class PlayerManager {

    private ConcurrentHashMap<Long, Player> playerMap = new ConcurrentHashMap<>();

    public Optional<Player> findPlayer(Long pid) {
        return Optional.ofNullable(playerMap.get(pid));
    }

    public Set<Map.Entry<Long, Player>> allPlayer() {

        return playerMap.entrySet();
    }

    public Player put(Player p) {

        return playerMap.put(p.getPid(), p);
    }

    public Player compute(long pid, BiFunction<? super Long, ? super Player, ? extends Player> remapping) {
        return playerMap.compute(pid, remapping);
    }

}
