package game.utils;

import com.google.common.base.Charsets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 16:56
 */
public class FileUtils {


    public static String readFile(String path) throws IOException {
        byte[] contentBytes = Files.readAllBytes(Paths.get(path));


        return new String(contentBytes, Charsets.UTF_8);

    }

    public static void writeFile(String path, String content) throws IOException {
        Files.write(Paths.get(path), content.getBytes(Charsets.UTF_8),
                StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
    }

}
