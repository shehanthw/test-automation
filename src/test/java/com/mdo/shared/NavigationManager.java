package com.mdo.shared;
import org.openqa.selenium.WebDriver;

public class NavigationManager extends WebDriverManager {
    private WebDriver driver;
    private DirPathManager dirPathManager;
    private PropertiesManager propertiesManager;

    public NavigationManager() {
//      call getDriver method from extended WebDriverManager class
        driver = getDriver();
        dirPathManager = new DirPathManager();
        propertiesManager = new PropertiesManager();
    }

    public void navigateToUrl() {
//      below variable to get url from pox.xml
        String url = System.getProperty("Env");

//        below variable to use for testing purposes
//        String url = "GEN_SSO_PROD";

        switch (url) {
            case "GEN_SSO_PROD":
                driver.get(propertiesManager.getEnvValue("GEN_SSO_PROD_URL"));
                break;
            case "GEN_SSO_UAT":
                driver.get(propertiesManager.getEnvValue("GEN_SSO_UAT_URL"));
                break;
            default:
               return;
        }
    }

}
