package com.mdo.shared;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager extends DirPathManager {
    Properties prop;
    InputStream input;

    public PropertiesManager() {
        try {
            prop = new Properties();
            input = new FileInputStream(getPropertiesFilePath());
            prop.load(input);
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

    public String getEnvValue(String envValue) {
        Dotenv dotenv = Dotenv.configure().load();
        String dotEnvValue = dotenv.get(envValue);
        return dotEnvValue;
    }

    public String getProperties(String variableName) {
        return prop.getProperty(variableName);
    }
}
