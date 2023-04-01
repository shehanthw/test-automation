package com.mdo.shared;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptExecutions {

    private WebDriver driver;
    JavascriptExecutor js;

    public JavaScriptExecutions(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    public void scrollToBottom() {
        js.executeScript("window.scrollBy(0,3000)", "");
    }

    public void scrollToTop() {
        js.executeScript("window.scrollTo(0, 0)");
    }

}
