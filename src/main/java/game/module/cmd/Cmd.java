package game.module.cmd;

import com.google.common.collect.ImmutableMap;
import game.base.constants.GameConstants;
import game.game.ResourceSourceEnum;
import game.module.hero.HeroService;
import game.player.Player;
import game.proto.TitleNewPush;
import game.proto.data.ItemData;
import game.proto.data.RunTask;
import game.proto.no.No;

import java.util.HashSet;
import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/3/10 23:28
 */
public enum Cmd {
    AddGoldCmd(1, "增加金币") {
        @Override
        public void run(final Player player, final List<String> line) {
            player.addGold(Integer.parseInt(line.get(0)), ResourceSourceEnum.TEST);
        }
    },
    AddExpCmd(2, "增加经验") {
        @Override
        public void run(final Player player, final List<String> line) {
            player.addPlayerExp(Integer.parseInt(line.get(0)), ResourceSourceEnum.TEST);
        }
    },
    SetLevelCmd(3, "设置等级") {
        @Override
        public void run(final Player player, final List<String> line) {
            player.setPlayerLevel(Integer.parseInt(line.get(0)), player.pd.getLevel());
        }
    },
    AddItem(4, "增加物品") {
        @Override
        public void run(final Player player, final List<String> line) {

            player.addItem(ItemData.newBuilder().setItemId(Integer.parseInt(line.get(0))).setCount(Integer.parseInt(line.get(1))).build(), GameConstants.ITEM_BAG);
        }
    },
    AddEquipment(5, "增加装备") {
        @Override
        public void run(final Player player, final List<String> line) {
            HeroService.addEquipment(player, Integer.parseInt(line.get(0)));
        }
    },
    AddGem(6, "增加宝石") {
        @Override
        public void run(final Player player, final List<String> line) {
            player.addGem(Integer.parseInt(line.get(0)), ResourceSourceEnum.TEST);
        }
    },
    AddTitle(7, "添加称谓") {
        @Override
        public void run(final Player player, final List<String> line) {
            int i = Integer.parseInt(line.get(0));
            player.pd.addCollectTitle(i);
            player.getTransport().send(No.TitleNewPush, TitleNewPush.newBuilder().setId(i).build());
        }
    },
    CMD8(8, "移除完成的任务") {
        @Override
        public void run(final Player player, final List<String> line) {
            int i = Integer.parseInt(line.get(0));
            player.D.removeCompleteTask(i);
        }
    },
    CMD9(9, "放弃任务") {
        @Override
        public void run(final Player player, final List<String> line) {
            int i = Integer.parseInt(line.get(0));
            player.pd.getTaskBuilder().removeRunTask(i);
        }
    },
    CMD10(10, "完成任务") {
        @Override
        public void run(final Player player, final List<String> line) {
            int i = Integer.parseInt(line.get(0));
            RunTask runTask = player.pd.getTaskBuilder().getRunTaskMap().get(i);
            if (runTask != null) {
                player.pd.getTaskBuilder().putRunTask(i, runTask.toBuilder().setComplete(true).buildPartial());
            }
        }
    },
    CMD11(11, "Clean npc show") {
        @Override
        public void run(final Player player, final List<String> line) {
            player.pd.setShowNpc(0);
        }
    },
    CMD12(12, "Remove hero") {
        @Override
        public void run(final Player player, final List<String> line) {
            int i = Integer.parseInt(line.get(0));
            player.pd.removeHero(i);
        }
    },
    CMD13(13, "Add hero") {
        @Override
        public void run(final Player player, final List<String> line) {
            int i = Integer.parseInt(line.get(0));
            HeroService.addHero(player, i, true);
        }
    },
    ;

    public final int id;

    public final String display;

    Cmd(final int id, final String module) {

        this.id = id;
        this.display = module;
    }

    private static final ImmutableMap<Integer, Cmd> map;

    static {
        final ImmutableMap.Builder<Integer, Cmd> builder = ImmutableMap.builder();
        final HashSet<Integer> ids = new HashSet<>();

        for (final Cmd value : Cmd.values()) {
            if (!ids.add(value.id)) {
                throw new IllegalStateException("id重复:" + value.id);
            }
            builder.put(value.id, value);
        }

        map = builder.build();
    }

    public static Cmd findById(final int id) {
        return map.get(id);
    }


    public abstract void run(Player player, List<String> list);

}
