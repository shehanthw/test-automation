package shared;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

    Properties prop;
    InputStream input;

    public PropertiesManager(String filePath) {
        try {
            prop = new Properties();
            input = new FileInputStream(filePath);
            prop.load(input);
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

    public String getProperties(String variableName) {
        return prop.getProperty(variableName);
    }

}
