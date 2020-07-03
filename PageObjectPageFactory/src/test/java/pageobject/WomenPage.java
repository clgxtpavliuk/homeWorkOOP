package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WomenPage extends Page {

    @FindBy(xpath = "//*[@id=\"ul_layered_id_attribute_group_3\"]/li")
    @CacheLookup
    public List<WebElement> colors;

    @FindBy(xpath = "//*[@class=\"color_to_pick_list clearfix\"]/li/a")
    @CacheLookup
    public List<WebElement> dressesColor;

    public WomenPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
