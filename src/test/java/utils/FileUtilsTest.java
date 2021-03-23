package utils;

import game.proto.data.PlayerData;
import game.utils.FileUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 17:03
 */
public class FileUtilsTest {

    @Test
    public void test1() throws IOException {
        FileUtils.writeFile("test.txt", "123霓虹");
    }

    @Test
    public void test2() throws IOException {
        String s = FileUtils.readFile("test.txt");
        System.out.println(s);
    }

    @Test
    public void test3() throws IOException, URISyntaxException {
        String s = FileUtils.readFile("data/task_对话.json");
        System.out.println(s);
    }

    @Test
    public void test4() {
        PlayerData.Builder b = PlayerData.newBuilder();
        b.setName("a");
        System.out.println(b.build());
        b.setName("b");
        System.out.println(b.build());

        b.getResourceBuilder().setPower(1);
        System.out.println(b.build());
        b.getTaskBuilder().putAcceptableTask(1, true);
        System.out.println(b.build());


    }

}
