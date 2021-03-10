package game.module.cmd;

import com.google.common.collect.ImmutableMap;
import game.player.Player;

import java.util.HashSet;
import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/3/10 23:28
 */
public enum Cmd {
    AddGoldCmd(1, "增加金币") {
        @Override
        public void run(Player player, List<String> line) {

        }
    };

    public final int id;

    public final String display;

    Cmd(int id, String module) {

        this.id = id;
        this.display = module;
    }

    private static final ImmutableMap<Integer, Cmd> map;

    static {
        ImmutableMap.Builder<Integer, Cmd> builder = ImmutableMap.builder();
        HashSet<Integer> ids = new HashSet<>();

        for (Cmd value : Cmd.values()) {
            if (!ids.add(value.id)) {
                throw new IllegalStateException("id重复:" + value.id);
            }
            builder.put(value.id, value);
        }

        map = builder.build();
    }

    public static Cmd findById(int id) {
        return map.get(id);
    }


    public abstract void run(Player player, List<String> list);

}
