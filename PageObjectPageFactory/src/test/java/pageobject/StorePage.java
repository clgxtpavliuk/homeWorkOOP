package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Waiters;

import java.util.concurrent.TimeUnit;

import static utils.Waiters.waitImplicit;

public class StorePage extends Page{
    @FindBy(xpath = "//a[@title=\"Women\"]")
    private WebElement womenButton;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    @CacheLookup
    private WebElement dressesButton;

    public StorePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        open();
    }

    public void open() {
        driver.get("http://automationpractice.com/index.php");
        waitImplicit(driver, Waiters.WAIT_10, TimeUnit.SECONDS);
    }

    public WomenPage goToWomen() {
        womenButton.click();
        return new WomenPage(driver);
    }

    public DressesPage goToDresses() {
        dressesButton.click();
        return new DressesPage(driver);
    }
}
