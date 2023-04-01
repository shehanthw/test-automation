package shared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WebDriverManager {

    public static WebDriver driver;
    private static DirPathManager dirPathManager = new DirPathManager();

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", dirPathManager.getWebDriverPath());
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");


        if (driver == null){
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quiteDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

}
