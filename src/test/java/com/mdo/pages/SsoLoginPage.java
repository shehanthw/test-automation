package com.mdo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SsoLoginPage {
    private WebDriver driver;

    @FindBy(id="email")
    WebElement loginUsername;

    @FindBy(id="password")
    WebElement loginPassword;

    @FindBy(id="btn-login")
    WebElement loginButton;

    public SsoLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        loginUsername.sendKeys(username);
    }

    public void enterPassword(String password){
        loginPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

}
