package pageobject;

import org.apache.commons.lang3.StringUtils;
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
        driver.manage().window().maximize();
    }

    public Page() {
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public FailInfo compareColor(List<WebElement> colors, List<WebElement> dressesColor) {

        for (WebElement elem : colors) {
            int counter = 0;
            String count = getCount(elem);
            String color = getColor(elem);
            String style = getStyle(elem.findElement(By.xpath("input")));

            for (WebElement el: dressesColor) {
                waitForLoading(driver, el);
                String styleDress = getStyle(el);
                if (StringUtils.equals(style, styleDress)) {
                    counter++;
                }
            }
            if (Integer.parseInt(count) != counter) {
                testResult.setCount(testResult.getCount() + 1);
                testResult.getInfo().add("The color " + color + "has incorrect value, should be" + counter);
            }
        }
        return testResult;
    }

    private String getStyle(WebElement input) {
        return input.getAttribute("style");
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
