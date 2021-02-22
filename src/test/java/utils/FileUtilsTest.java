package utils;

import game.utils.FileUtils;
import org.junit.Test;

import java.io.IOException;

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
}
