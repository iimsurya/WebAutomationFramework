package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utilities {


    public static String getValueofProperty(String key){

        FileInputStream fileInputStream;
        try {
             fileInputStream = new FileInputStream("src/main/resources/application.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        Properties prop = new Properties();
        try {
            prop.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String value = prop.get(key).toString();
        //System.out.println(value);

        return value;
    }

}
