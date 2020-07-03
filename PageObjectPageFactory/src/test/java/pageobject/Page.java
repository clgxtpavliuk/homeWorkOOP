package pageobject;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FailInfo;

import java.util.List;

import static utils.Waiters.waitForLoading;

public class Page {
    WebDriver driver;
    private FailInfo testResult = new FailInfo();

    public Page(WebDriver driver) {
        this.driver = driver;
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
    }

    public Page() {
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public FailInfo compareColor(List<WebElement> colors, List<WebElement> dresses, WebElement loadElement) {
        for (WebElement elem : colors) {
            String count = getCount(elem);
            String color = getColor(elem);
            chooseColor(elem);
            waitForLoading(driver, loadElement);

            if (Integer.parseInt(count) != getDressesCount(dresses)) {
                testResult.setCount(testResult.getCount() + 1);
                testResult.getInfo().add("The color " + color + "has incorrect value");
            }
        }
        return testResult;
    }

    private int getDressesCount(List<WebElement> dresses) {
        return dresses.size();
    }

    private void chooseColor(WebElement elem) {
        elem.findElement(By.xpath("input")).click();
    }

    private String getColor(WebElement elem) {
        String color;
        color = elem.findElement(By.xpath("label/a")).getText();
        return color;
    }

    private String getCount(WebElement elem) {
        String count;
        count = elem.findElement(By.xpath("label/a/span")).getText().replace("(", "").replace(")", "");
        return count;
    }


}
