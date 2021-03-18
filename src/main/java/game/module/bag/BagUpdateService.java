package game.module.bag;

import game.player.Player;
import game.proto.data.BagSlot;

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

    /**
     * 更新银行
     */
    BagUpdateService updatePlayerBank = new BagUpdateService() {
        @Override
        public void update(Player p, BagSlot d) {
            if (d.getData().getCount() == 0) {
                p.pd.removeBank(d.getSlotId());
                box(p).count -= 1;

            } else {
                if (!p.pd.containsBank(d.getSlotId())) {
                    box(p).count += 1;
                }
                p.getPd().putBank(d.getSlotId(), d);
                box(p).bagSlotMap.put(d.getData().getItemId(), d);
            }
        }

        @Override
        public void clean(Player p) {
            box(p).bagSlotMap.clear();
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
            if (d.getData().getCount() == 0) {
                p.pd.removeBag(d.getSlotId());
                box(p).count -= 1;
            } else {
                if (!p.pd.containsBag(d.getSlotId())) {
                    box(p).count += 1;
                }
                p.pd.putBag(d.getSlotId(), d);
                box(p).bagSlotMap.put(d.getData().getItemId(), d);
            }
        }

        @Override
        public void clean(Player p) {
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
