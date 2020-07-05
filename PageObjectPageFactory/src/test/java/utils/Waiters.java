package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waiters {

    public static final int WAIT_10 = 10;
    public static final int WAIT_60 = 60;

    public static void waitImplicit(WebDriver driver, int amountOfTime, TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(amountOfTime, timeUnit);
    }

    public static void waitForURL(WebDriver driver, String automation_site_url) {
        WebDriverWait wait = new WebDriverWait(driver, Waiters.WAIT_60);
        wait.until(ExpectedConditions.urlToBe(automation_site_url));
    }

    public static void waitForLoading(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Waiters.WAIT_60);
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, "style"));
    }

    public static void waitForVisibility(WebDriver driver, WebElement prRange) {
        WebDriverWait wait = new WebDriverWait(driver, Waiters.WAIT_60);
        wait.until(ExpectedConditions.visibilityOf(prRange));
    }
}
