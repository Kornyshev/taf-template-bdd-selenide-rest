package org.example.core.properties;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

@Slf4j
public class PropertiesLoader {

    private static PropertiesLoader propertiesLoader;

    private PropertiesLoader() {
    }

    public static synchronized PropertiesLoader getInstance() {
        if (Objects.isNull(propertiesLoader)) {
            propertiesLoader = new PropertiesLoader();
        }
        return propertiesLoader;
    }

    public void readAllProperties() {
        String user = System.getProperty("user", "user");
        log.debug("Reading properties for user: {}", user);
        Properties general = readPropertiesFromFile(new Properties(), "properties/general.properties");
        Properties propertiesFromFile = readPropertiesFromFile(general, "properties/" + user + ".properties");
        saveToSystemProperties(propertiesFromFile);
    }

    private Properties readPropertiesFromFile(Properties target, String fileName) {
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(fileName)) {
            target.load(inputStream);
        } catch (IOException e) {
            log.error("Unable to read properties from file", e);
        }
        return target;
    }

    private void saveToSystemProperties(Properties properties) {
        log.info("\nSystem Properties\n");
        System.getProperties().forEach((key, value) -> log.info("Key: {}, Value: {}", key, value));
        log.info("\n");
        properties.stringPropertyNames().forEach(propertyName -> {
            boolean propertyIsInSystemVariables = !System.getProperties().containsKey(propertyName);
            log.info("Property {} is in System Variables: {}", propertyName, propertyIsInSystemVariables);
            if (propertyIsInSystemVariables) {
                System.setProperty(propertyName, properties.getProperty(propertyName));
            }
        });
    }

}
