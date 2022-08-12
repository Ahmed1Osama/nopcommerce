package org.example.stepDefs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class configurationReader {
    public static void set(String key , String value) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("config.properties");
        prop.load(fis);
        prop.setProperty(key, value);
        fis.close();

        FileOutputStream fos = new FileOutputStream("config.properties");
        prop.store(fos,"");

    }
    public static String get (String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("config.properties");
        prop.load(fis);
        String value = prop.getProperty(key);
        fis.close();
        return value;

    }

}
