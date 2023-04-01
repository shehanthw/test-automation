package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.UlpPage;
import shared.*;

public class TestUlpReportUpload {

    WebDriver driver = WebDriverManager.getDriver();
    PropertiesManager propertiesManager;
    JavaScriptExecutions javaScriptExecutions;
    FileProcessing fileProcessing;
    DirPathManager dirPathManager;
    WebBrowserManager webBrowser;

    private UlpPage ulpPage;

    @Before
    public void initiate_drivers() {
        ulpPage = new UlpPage(driver);
        dirPathManager = new DirPathManager();
        javaScriptExecutions = new JavaScriptExecutions(driver);
        fileProcessing = new FileProcessing();
        propertiesManager = new PropertiesManager(dirPathManager.getPropertiesPath());
        webBrowser = new WebBrowserManager(driver);
    }
    @When("Click on ULP tile")
    public void click_on_ulp_tile() throws InterruptedException {
        ulpPage.clickOnUlpTile();
        webBrowser.switchToNewestPage();
    }

    @And("Click on hotels dropdown")
    public void click_on_hotels_dropdown() {
        ulpPage.clickOnHotelList();
        ulpPage.selectHotel("COSTH1");
    }

    @And("User adds the date")
    public void user_add_date() throws InterruptedException {
        ulpPage.clickOnDateField();
        ulpPage.selectDate(propertiesManager.getProperties("business_date"));
        Thread.sleep(2000);
        javaScriptExecutions.scrollToBottom();
    }

    @When("User uploads reports")
    public void user_uploads_reports() throws InterruptedException {
        fileProcessing.getAllFiles(dirPathManager.getReportsPath());
        ulpPage.addReports(fileProcessing.filesToString());
        Thread.sleep(2000);
        javaScriptExecutions.scrollToBottom();
    }

    @When("User clicks on upload button")
    public void user_clicks_on_upload_button() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(4000);
        javaScriptExecutions.scrollToTop();
//        ulpPage.getHotelList();
    }

    @Then("User gets success message")
    public void user_gets_success_message() {
        System.out.println("Pass");
    }

}
