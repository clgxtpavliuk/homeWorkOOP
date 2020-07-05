package pageobject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.Patterns_HomeTask2;
import utils.FailInfo;
import utils.PriceInfo;
import utils.PriceParser;

import java.util.*;

import static utils.Waiters.waitForLoading;
import static utils.Waiters.waitForVisibility;

public class Page {
    private static Logger logger = LogManager.getLogger(Page.class);
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

            for (WebElement el : dressesColor) {
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

    public FailInfo checkMinMaxPrice(WebElement prRange, List<WebElement> prices) {

        waitForVisibility(driver, prRange);

        String priceRange = prRange.getText();
        logger.info("Price Range {}", priceRange);
        PriceInfo priceRangeInfo = PriceParser.parsePriceRange(priceRange);

        List<Double> pricesDouble = new ArrayList<Double>();

        for (WebElement elem : prices) {
            waitForVisibility(driver, elem);
            pricesDouble.add(PriceParser.parsePrice(elem.getText()));
        }

        DoubleSummaryStatistics statistics = pricesDouble.stream().mapToDouble(Double::doubleValue).summaryStatistics();
        double minPrice = statistics.getMin();
        double maxPrice = statistics.getMax();

        logger.info("Min price on the page {}", minPrice);
        logger.info("Max price on the page {}", maxPrice);

        if (minPrice < priceRangeInfo.getMinPrice() || maxPrice > priceRangeInfo.getMaxPrice()) {
            testResult.setCount(testResult.getCount() + 1);
            testResult.getInfo().add("Price range is nit correct" + minPrice + "- should be Min Price" + maxPrice + "- should be Max Price");
        }
        return testResult;
    }
}
