package com.mdo.pages;

import com.mdo.shared.WebBrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class UlpPage extends WebBrowserManager {

    private WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath="//*[text()='ULP']")
    WebElement ulpTile;

    @FindBy(xpath="//*[@id='hotel']/div")
    WebElement hotelsDropdown;
    public String hotelDropDownElement = "//*[@id='hotel']/div";

    @FindBy(id="react-select-2-input")
    WebElement hotelsDropDownInputBox;

    @FindBy(xpath="//*[@class='react-datepicker__input-container']")
    WebElement datesField;

    @FindBy(xpath="//input[@class='businessDate react-datepicker-ignore-onclickoutside']")
    WebElement datesFieldInput;

    @FindBy(xpath="//*[@id='__next']/div/div/div[3]/main/div/div/div[3]/section/div[1]/input")
    WebElement fileInput;

    @FindBy(xpath="//*[text()='Submit']")
    WebElement ulpSubmitBtn;

    @FindBy(xpath = "//div[@class=' css-2613qy-menu']")
    WebElement hotelsDropdownHidden;

    public UlpPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void clickOnUlpTile() {
        ulpTile.click();
    }

    public void clickOnHotelList() {
        waitForElementToPresent(hotelsDropdown);
        hotelsDropdown.click();
    }

    public void selectHotel(String hotelName) {
        hotelsDropDownInputBox.sendKeys(hotelName);
        hotelsDropDownInputBox.sendKeys(Keys.chord(Keys.ENTER));
    }

    public void clickOnDateField() {
        waitForElementToPresent(datesField);
        datesField.click();
    }

    public void selectDate(String date) {
        waitForElementToPresent(datesFieldInput);
        datesFieldInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        datesFieldInput.sendKeys(Keys.chord(Keys.BACK_SPACE));
        datesFieldInput.sendKeys(date);
        datesFieldInput.sendKeys(Keys.chord(Keys.ENTER));
    }

    public void addReports(String filesList) {
        fileInput.sendKeys(filesList);
    }

    public void clickSubmitButton() {
        waitForElementToPresent(ulpSubmitBtn);
        ulpSubmitBtn.click();
    }

    public void clearReports() {
        fileInput.clear();
    }

    public void getHotelList() {
        hotelsDropdown.click();
        String text = hotelsDropdownHidden.getText();
        System.out.println(hotelsDropdownHidden.getSize());
    }
}
