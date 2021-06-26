package game.module.bag;

import com.google.common.collect.Multimap;
import game.player.Player;
import game.proto.data.BagSlot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Yunzhe.Jin
 * 2021/3/17 23:20
 */
public interface BagUpdateService {

    default void update(Player p, BagSlot d) {
    }

    default void clean(Player p) {
    }

    ItemBoxData box(Player p);

    BagSlot find(Player p, int slotId);

    Map<Integer, BagSlot> findAll(Player p);

    default List<BagSlot> removeItem(Player p, int itemId, int count) {

        ItemBoxData box = box(p);

        if (!box.hasItem(itemId, count)) {
            return Collections.emptyList();
        }

        List<BagSlot> remove = new ArrayList<>(1);
        List<BagSlot> update = new ArrayList<>(1);

        Multimap<Integer, BagSlot> bagSlotMap = box.bagSlotMap;
        for (BagSlot bagSlot : bagSlotMap.get(itemId)) {
            bagSlotMap.remove(itemId, bagSlot);
            int have = bagSlot.getData().getCount();
            BagSlot.Builder builder = bagSlot.toBuilder();
            if (have <= count) {
                count -= have;
                builder.getDataBuilder().setCount(0);
                remove.add(builder.build());
            } else {
                builder.getDataBuilder().setCount(have - count);
                update.add(builder.build());
                break;
            }

            if (count == 0) {
                break;
            }

        }
        for (BagSlot bagSlot : remove) {
            update(p, bagSlot);
        }

        for (BagSlot bagSlot : update) {
            update(p, bagSlot);
        }
        remove.addAll(update);
        return remove;
    }

    /**
     * 更新银行
     */
    BagUpdateService updatePlayerBank = new BagUpdateService() {
        @Override
        public void update(Player p, BagSlot d) {
            ItemBoxData box = box(p);
            if (d.getData().getCount() == 0) {
                p.pd.removeBank(d.getSlotId());
                box.count -= 1;

            } else {
                if (!p.pd.containsBank(d.getSlotId())) {
                    box.count += 1;
                }
                p.getPd().putBank(d.getSlotId(), d);
                box.bagSlotMap.put(d.getData().getItemId(), d);
            }
        }

        @Override
        public void clean(Player p) {
            box(p).bagSlotMap.clear();
            box(p).capacity = p.pd.getBagCapacity();
            box(p).count = 0;
            p.pd.clearBank();

        }

        @Override
        public ItemBoxData box(Player p) {
            return p.bank;
        }

        @Override
        public BagSlot find(Player p, int slotId) {
            return p.pd.getBankMap().get(slotId);
        }

        @Override
        public Map<Integer, BagSlot> findAll(Player p) {
            return p.pd.getBankMap();
        }

    };
    /**
     * 更新背包
     */
    BagUpdateService updatePlayerBag = new BagUpdateService() {
        @Override
        public void update(Player p, BagSlot d) {
            ItemBoxData box = box(p);
            if (d.getData().getCount() == 0) {
                p.pd.removeBag(d.getSlotId());
                box.count -= 1;
            } else {
                if (!p.pd.containsBag(d.getSlotId())) {
                    box.count += 1;
                }
                p.pd.putBag(d.getSlotId(), d);
                box.bagSlotMap.put(d.getData().getItemId(), d);
            }
        }

        @Override
        public void clean(Player p) {
            box(p).capacity = p.pd.getBagCapacity();
            box(p).count = 0;
            box(p).bagSlotMap.clear();
            p.pd.clearBag();
        }

        @Override
        public ItemBoxData box(Player p) {
            return p.bag;
        }

        @Override
        public BagSlot find(Player p, int slotId) {
            return p.pd.getBagMap().get(slotId);
        }

        @Override
        public Map<Integer, BagSlot> findAll(Player p) {
            return p.pd.getBagMap();
        }


    };


}
