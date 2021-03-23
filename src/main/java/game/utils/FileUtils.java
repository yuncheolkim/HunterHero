package game.utils;

import com.google.common.base.Charsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 16:56
 */
public class FileUtils {

    public static String readFile(String path) throws IOException {
        InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(path);
        BufferedReader bufferedReader = null;
        StringBuilder builder;
        try {
            assert inputStream != null;
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            builder = new StringBuilder();
            String s = bufferedReader.readLine();
            while (s != null) {
                builder.append(s);
                s = bufferedReader.readLine();
            }
        } finally {

            assert bufferedReader != null;
            bufferedReader.close();
        }

        return builder.toString();
//        byte[] contentBytes = Files.readAllBytes(Paths.get(path));
//
//        return new String(contentBytes, Charsets.UTF_8);
    }

    public static byte[] readByteFile(String path) throws IOException {
        return Files.readAllBytes(Paths.get(path));
    }


    public static void createDir(String path) throws IOException {

        if (!hasFile(path)) {
            Files.createDirectories(Paths.get(path));
        }
    }


    public static void writeFile(String path, String content) throws IOException {
        Files.write(Paths.get(path), content.getBytes(Charsets.UTF_8),
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static void writeByteFile(String path, byte[] content) throws IOException {
        Files.write(Paths.get(path), content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static boolean hasFile(String path) {
        return Files.exists(Paths.get(path));
    }
}
