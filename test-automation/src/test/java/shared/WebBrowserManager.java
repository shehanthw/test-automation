package shared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WebBrowserManager {
    private WebDriver driver;
    WebDriverWait wait;

    public WebBrowserManager(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void switchToNewestPage() {
        Set<String> handles = this.driver.getWindowHandles();
        String originalWindow = this.driver.getWindowHandle();
        Iterator<String> iterator = handles.iterator();
        while(iterator.hasNext()) {
            String newWindow = iterator.next();
            if(!originalWindow.equalsIgnoreCase(newWindow)){
                driver.switchTo().window(newWindow);
            }
        }
    }
}
