package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.SsoDashboard;
import pages.SsoLoginPage;
import pages.UlpPage;
import shared.DirPathManager;
import shared.PropertiesManager;
import shared.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@RunWith(Cucumber.class)
public class TestSsoLogin {
    WebDriver driver = WebDriverManager.getDriver();
    Properties prop;
    InputStream input;
    PropertiesManager propertiesManager;
    DirPathManager dirPathManager;
    private SsoLoginPage loginPage;

    public TestSsoLogin() {
        dirPathManager = new DirPathManager();
        propertiesManager = new PropertiesManager(dirPathManager.getPropertiesPath());
    }

    @Before
    public void initiate_drivers() throws IOException {
        loginPage = new SsoLoginPage(driver);
    }

    @Given("User navigates to login")
    public void user_navigates_to_login(){
        driver.get(propertiesManager.getProperties("url"));
        System.out.println("Pass");
    }

    @Then("User is on sso login page")
    public void user_is_on_sso_login_page() {
        System.out.println("User logins successfully");
    }

    @When("User enters username")
    public void user_enters_username() {
        loginPage.enterUsername(propertiesManager.getProperties("sso_username"));
    }

    @And("User enters password")
    public void user_enters_password() {
        loginPage.enterPassword(propertiesManager.getProperties("sso_password"));
    }

    @And("User clicks on login button")
    public void user_clicks_on_login_button(){
        loginPage.clickLoginButton();
    }

    @Then("User redirects to sso dashboard")
    public void user_redirects_to_sso_dashboard() throws InterruptedException {
        System.out.println("Pass");
        Thread.sleep(2000);
    }
}
