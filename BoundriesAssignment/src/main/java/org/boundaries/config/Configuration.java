package org.boundaries.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.boundaries.constants.ExceptionMessages.PROPERTIES_FILE_LOAD_ERROR;

public class Configuration {

    private static final Logger LOGGER = LogManager.getLogger(Configuration.class);
    private static final Properties properties = new Properties();

    public static String getProperty(String key) {
        try {
            InputStream inputStream = Configuration.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);
            return properties.getProperty(key);
        } catch (IOException e) {
            LOGGER.error(PROPERTIES_FILE_LOAD_ERROR, e);
        }

        return null;
    }
}
