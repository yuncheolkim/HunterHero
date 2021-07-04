import com.fasterxml.jackson.annotation.JsonProperty;
import game.utils.JsonUtil;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yunzhe.Jin
 * 2021/2/25 10:05
 */
public class CommonTest {

    @Test
    public void test1() {

        final D d = new D();
        d.task = new HashSet<>();

        d.task.add(1123);
        d.task.add(1);

        final String s = JsonUtil.toJsonString(d);
        System.out.println(s);

    }

}

class D {
    @JsonProperty
    public Set<Integer> task;
}

