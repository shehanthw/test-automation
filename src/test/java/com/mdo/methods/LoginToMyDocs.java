package com.mdo.methods;

import com.mdo.pages.*;
import com.mdo.shared.*;
import org.openqa.selenium.WebDriver;

public class LoginToMyDocs extends WebDriverManager {

    private WebDriver driver;
    private NavigationManager navigationManager;
    private SsoLoginPage ssoLoginPage;
    private WebBrowserManager webBrowserManager;
    private SsoDashboard ssoDashboard;
    private JavaScriptExecutions javaScriptExecutions;

    public LoginToMyDocs() {
        driver = getDriver();
        navigationManager = new NavigationManager();
        ssoLoginPage = new SsoLoginPage(driver);
        webBrowserManager = new WebBrowserManager();
        ssoDashboard = new SsoDashboard(driver);
        javaScriptExecutions = new JavaScriptExecutions(driver);
    }

    public void navigateToMyDocs(String username, String password) {
        navigationManager.navigateToUrl();
        ssoLoginPage.enterUsername(username);
        ssoLoginPage.enterPassword(password);
        ssoLoginPage.clickLoginButton();

        ssoDashboard.clickOnMyDocsTile();
        webBrowserManager.switchToNewestPage();
    }

}
