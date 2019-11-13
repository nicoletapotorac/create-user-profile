package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    File file = new File("./my.properties");

    FileInputStream fileInput = null;
    Properties properties = new Properties();

    public ReadProperties() {
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(fileInput);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseURL(){
        return properties.getProperty("baseURL");
    }
}