package game.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import game.base.Logs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yunzhe.Jin
 * 2020/10/29 10:55
 */
public class JacksonUtil {
    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static Map<String, Object> toMap(String body) {
        try {
            return mapper.readValue(body, new TypeReference<Map<String, Object>>() {
            });
        } catch (IOException e) {
            Logs.C.error("", e);
        }

        return new HashMap<>();
    }

    public static <T> T toObject(String body, Class<T> clazz) {
        try {
            return mapper.readValue(body, clazz);
        } catch (IOException e) {
            Logs.C.error("", e);
        }

        return null;
    }

    public static String toStr(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            Logs.C.error("", e);
            return "";
        }
    }
}
