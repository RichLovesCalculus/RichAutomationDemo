package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SecretsLoader {
    private final Properties properties = new Properties();

    public SecretsLoader(String resourcePath) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (input == null) {
                throw new RuntimeException("Resource not found: " + resourcePath);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties from " + resourcePath, e);
        }
    }

    public String get(String key) {
        return properties.getProperty(key);
    }
}

