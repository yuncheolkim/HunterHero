package game.module.bag;

import game.player.Player;
import game.proto.data.BagSlot;

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

    /**
     * 更新银行
     */
    BagUpdateService updatePlayerBank = new BagUpdateService() {
        @Override
        public void update(Player p, BagSlot d) {
            if (d.getData().getCount() == 0) {
                box(p).bagSlotMap.remove(d.getData().getItemId(), d);

            } else {
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

    };
    /**
     * 更新背包
     */
    BagUpdateService updatePlayerBag = new BagUpdateService() {
        @Override
        public void update(Player p, BagSlot d) {
            if (d.getData().getCount() == 0) {
                box(p).bagSlotMap.remove(d.getData().getItemId(), d);

            } else {
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


    };


}
