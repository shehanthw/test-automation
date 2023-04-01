package com.mdo.shared;

public class DirPathManager {

    private String rootPath = System.getProperty("user.dir");

//  --------->  web drivers ------------------------------------------------------------------------------------
    private String chromeDriverPath = "/src/test/resources/drivers/chromedriver.exe";
    private String firefoxDriverPath = "/src/test/resources/drivers/geckodriver.exe";
    private String edgeDriverPath = "/src/test/resources/drivers/msedgedriver.exe";


//  --------->  reports / static file paths ------------------------------------------------------------------------------------
    private String reportsContentPath = "/src/test/resources/reports/";


//  --------->  property files ------------------------------------------------------------------------------------

    public String getChromeDriverPath(){
        String webDriverPath = rootPath + chromeDriverPath;
        return webDriverPath;
    }

    public String getFireboxDriverPath() {
        String firefoxDriver = rootPath + firefoxDriverPath;
        return firefoxDriver;
    }

    public String getEdgeDriverPath() {
        String edgeDriver = rootPath + edgeDriverPath;
        return edgeDriver;
    }

    public String getReportsPath() {
        String reportsPath = rootPath + reportsContentPath;
        return reportsPath;
    }

}
