package utils;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/7/5 15:56
 */
public class ListTest {
    @Test
    public void test1() {
        final Multimap<Integer, Integer> skillMap = ArrayListMultimap.create();

        skillMap.put(1, 3);
        skillMap.put(1, 2);
        skillMap.put(1, 1);

        final List<Integer> integers = (List<Integer>) skillMap.get(1);
        System.out.println(integers);
        integers.sort(Comparator.comparingInt(o -> o));
        System.out.println(integers);
        System.out.println(skillMap.get(1));
    }
}
