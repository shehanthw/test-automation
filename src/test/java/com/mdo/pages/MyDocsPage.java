package com.mdo.pages;

import com.mdo.shared.WebBrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MyDocsPage {
    private WebBrowserManager webBrowserManager;

    @FindBy(xpath="(//div[@class='modal-content'])[2]")
    WebElement dialogBox;

    @FindBy(xpath="/html[1]/body[1]/div[4]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/span[1]/span[1]/span[1]/span[1]")
    WebElement ssoPmsDropDown;

    @FindBy(xpath="//*[@class='select2-results__options']/li")
    String pmsListParent = "//*[@class='select2-results__options']/li";

    private WebDriver driver;

    public MyDocsPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webBrowserManager = new WebBrowserManager();
    }

    public String getPageTitle() {
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public List<String> getPmsList() {
        webBrowserManager.waitForElementToPresent(dialogBox);
        dialogBox.click();
        ssoPmsDropDown.click();
        List<WebElement> allChildElements = driver.findElements(By.xpath(pmsListParent));

        int index = 1;
        List<String> pmsList = new ArrayList<>();
        for(WebElement pmsElement : allChildElements){
            WebElement singlePmsElement = driver.findElement(By.xpath("//*[@class='select2-results__options']/li["+ index++ +"]"));
            pmsList.add(singlePmsElement.getText());
        }
        return pmsList;
    }

}
