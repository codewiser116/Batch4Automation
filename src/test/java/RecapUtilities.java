import utilities.Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class RecapUtilities {
    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();

        FileInputStream inputStream = new FileInputStream
                ("src/test/resources/settings.properties");

        prop.load(inputStream);

        System.out.println(prop.get("database"));







    }
}
