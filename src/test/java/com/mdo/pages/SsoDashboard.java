package com.mdo.pages;

import com.mdo.shared.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SsoDashboard {
    private WebDriver driver;
    private WebBrowserManager webBrowserManager;

    @FindBy(xpath="//*[text()='ULP']")
    WebElement ulpTile;

    @FindBy(xpath="//h3[text()='Reports Repository']")
    WebElement myDocsTile;

    public SsoDashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webBrowserManager = new WebBrowserManager();
    }

    public void clickOnUlpTile() {
        webBrowserManager.waitForElementToPresent(ulpTile);
        ulpTile.click();
    }

    public void clickOnMyDocsTile() {
        webBrowserManager.waitForElementToPresent(myDocsTile);
        myDocsTile.click();
    }

}
