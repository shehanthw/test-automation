package com.mdo.shared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebDriverManager {
    public static WebDriver driver;
    private static DirPathManager dirPathManager = new DirPathManager();

    public static WebDriver getDriver() {
        String browser = System.getProperty("Browser");
//        String browser = "chrome";

        switch(browser) {
            case "chrome":
                runWithChrome();
                return driver;
            case "firefox":
                runWithFirebox();
                return driver;
            case "edge":
                runWithEdge();
                return driver;
            default:
                return null;
        }
    }

    public static void runWithChrome() {
        System.setProperty("webdriver.chrome.driver", dirPathManager.getChromeDriverPath());
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        if (driver == null){
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
            driver.manage().window().maximize();
        }
    }

    public static void runWithFirebox() {
        System.setProperty("webdriver.gecko.driver", dirPathManager.getFireboxDriverPath());

        if (driver == null){
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
            driver.manage().window().maximize();
        }
    }

    public static void runWithEdge() {
        System.setProperty("webdriver.edge.driver", dirPathManager.getEdgeDriverPath());

        if (driver == null){
            driver = new EdgeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
            driver.manage().window().maximize();
        }
    }

    public static void quiteDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

}
