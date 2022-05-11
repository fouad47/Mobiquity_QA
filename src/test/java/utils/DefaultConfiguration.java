package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DefaultConfiguration {
    private static final String CONFIG_FILE_NAME = "conf/default.txt";

    public static String getPropertyValue(String propertyName){
        String value = null;
        Properties properties = new Properties();
        try (InputStream fileInput =
                     new FileInputStream(CONFIG_FILE_NAME)) {
            properties.load(fileInput);
            value = properties.getProperty(propertyName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
