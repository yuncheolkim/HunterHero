package config;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;

/**
 * @author Yunzhe.Jin
 * 2021/2/24 17:47
 */
public class ConfigTypeReference<T> extends TypeReference<Map<Integer, T>> {
}
