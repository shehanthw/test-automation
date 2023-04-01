package com.mdo.shared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WebBrowserManager extends WebDriverManager {
    private WebDriver driver;
    WebDriverWait wait;

    public WebBrowserManager() {
        driver = getDriver();
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

    public void waitForElementToPresent(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
