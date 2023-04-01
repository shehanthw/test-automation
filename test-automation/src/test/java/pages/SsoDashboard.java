package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SsoDashboard {
    private WebDriver driver;

    @FindBy(xpath="//*[text()='ULP']")
    WebElement ulpTile;

    @FindBy(xpath="//h3[text()='Reports Repository']")
    WebElement myDocsTile;

    public SsoDashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnUlpTile() {
        ulpTile.click();
    }

    public void clickOnMyDocsTile() {
        myDocsTile.click();
    }

}
