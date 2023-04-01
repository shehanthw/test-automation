package shared;

public class DirPathManager {

    private String rootPath = System.getProperty("user.dir");
    private String webDriverContentPath = "/src/test/resources/drivers/chromedriver.exe";
    private String reportsContentPath = "/src/test/resources/reports/";
    private String propertiesContentPath = "/src/test/resources/properties/config.properties";

    public String getWebDriverPath(){
        String webDriverPath = rootPath + webDriverContentPath;
        return webDriverPath;
    }

    public String getReportsPath() {
        String reportsPath = rootPath + reportsContentPath;
        return reportsPath;
    }

    public String getPropertiesPath() {
        String propertiesPath = rootPath + propertiesContentPath;
        return propertiesPath;
    }

}
