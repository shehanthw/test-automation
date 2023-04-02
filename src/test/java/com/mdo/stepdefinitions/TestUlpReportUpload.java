package com.mdo.stepdefinitions;

import com.mdo.pages.UlpPage;
import com.mdo.shared.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import com.mdo.pages.SsoLoginPage;

public class TestUlpReportUpload extends WebDriverManager {
    private WebDriver driver;
    private SsoLoginPage loginPage;
    private WebBrowserManager webBrowserManager;
    private UlpPage ulpPage;
    private FileProcessing fileProcessing;
    private NavigationManager navigationManager;
    private PropertiesManager propertiesManager;

    public TestUlpReportUpload() {
        driver = getDriver();
        loginPage = new SsoLoginPage(driver);
        webBrowserManager = new WebBrowserManager();
        ulpPage = new UlpPage(driver);
        fileProcessing = new FileProcessing();
        navigationManager = new NavigationManager();
        propertiesManager = new PropertiesManager();
    }

    @Given("User navigates to ULP")
    public void user_navigates_to_ulp() {
        navigationManager.navigateToUrl();
        loginPage.enterUsername(propertiesManager.getEnvValue("sso_username"));
        loginPage.enterPassword(propertiesManager.getEnvValue("sso_password"));
        loginPage.clickLoginButton();
        ulpPage.clickOnUlpTile();
    }

    @Given("Click on hotels dropdown")
    public void click_on_hotels_dropdown() {
        webBrowserManager.switchToNewestPage();
        ulpPage.clickOnHotelList();
        ulpPage.selectHotel(propertiesManager.getEnvValue("hotel"));
    }

    @Given("User adds the date")
    public void user_adds_the_date() {
        ulpPage.clickOnDateField();
        ulpPage.selectDate(propertiesManager.getEnvValue("business_date"));
    }

    @When("User uploads reports")
    public void user_uploads_reports() {
        ulpPage.addReports(fileProcessing.filesToString());
    }

    @When("User clicks on upload button")
    public void user_clicks_on_upload_button() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("pass");
    }

    @Then("User gets success message")
    public void user_gets_success_message() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("pass");
        quiteDriver();
    }
}
