package game.module.bag;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import game.proto.data.BagSlot;

import java.util.Collection;

/**
 * @author Yunzhe.Jin
 * 2021/3/17 22:36
 */
public class ItemBoxData {

    /**
     * key: itemId
     */
    public final Multimap<Integer, BagSlot> bagSlotMap = LinkedHashMultimap.create();

    public int count;
    public int capacity;


    public int remain() {
        return Math.max(0, capacity - count);
    }

    public boolean hasItem(int itemId) {
        return bagSlotMap.containsKey(itemId);
    }

    public boolean hasItem(int itemId, int count) {

        Collection<BagSlot> bagSlots = bagSlotMap.get(itemId);

        if (bagSlots.isEmpty()) {
            return false;
        }
        int have = 0;

        for (BagSlot bagSlot : bagSlots) {
            have += bagSlot.getData().getCount();
        }

        return have >= count;
    }

}
