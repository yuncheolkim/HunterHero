package game.module.bag;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import game.proto.data.BagSlot;

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
}
