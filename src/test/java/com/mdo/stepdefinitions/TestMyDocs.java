package com.mdo.stepdefinitions;

import com.mdo.methods.LoginToMyDocs;
import com.mdo.pages.MyDocsPage;
import com.mdo.shared.PropertiesManager;
import com.mdo.shared.WebDriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;


public class TestMyDocs extends WebDriverManager {

    private WebDriver driver;
    private LoginToMyDocs loginToMyDocs;
    private PropertiesManager propertiesManager;
    private MyDocsPage myDocsPage;

    public TestMyDocs() {
        driver = getDriver();
        loginToMyDocs = new LoginToMyDocs();
        propertiesManager = new PropertiesManager();
        myDocsPage = new MyDocsPage(driver);
    }

    @Given("MD_Log into SSO")
    public void md_log_into_sso() throws InterruptedException {
        loginToMyDocs.navigateToMyDocs(propertiesManager.getEnvValue("sso_username"), propertiesManager.getEnvValue("sso_password"));
        System.out.println("Login to SSO -> Pass");
    }

    @When("MD_Validate PMS dropdown")
    public void md_validate_pms_dropdown() {
        String actualTitle = myDocsPage.getPageTitle();
        String expectedTitle = "myDigitalOffice";
        Assert.assertEquals(expectedTitle, actualTitle);

        String[] values = propertiesManager.getEnvValue("PMS").split(",");
        List<String> expectedPmsValueList = Arrays.asList(values);

//        check whether expectedList contains the values of actual pms list of myDocs popup box
        boolean containsAll = myDocsPage.getPmsList().containsAll(expectedPmsValueList);

        System.out.println("Expected List :" + expectedPmsValueList);
        System.out.println("Actual List :" + myDocsPage.getPmsList());
        String pmsValidatingResult = containsAll ? "PMS list validation successful" : "PMS list validation failed";
        System.out.println(pmsValidatingResult);
    }

    @Then("MD_Quit browser")
    public void md_quit_browser() {
        System.out.println("pass");
        quiteDriver();
    }
}
