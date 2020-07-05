package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.DressesPage;
import pageobject.StorePage;
import pageobject.WomenPage;
import utils.FailInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Patterns_HomeTask2 {
    private static WebDriver driver = new ChromeDriver();
    private static Logger logger = LogManager.getLogger(Patterns_HomeTask2.class);

    @Test
    public void checkPrice() throws InterruptedException {
        logger.info("Test checkPrice started");

        StorePage storePage = new StorePage(driver);

        logger.info("Store page openned");

        DressesPage dressesPage = storePage.goToDresses();

        logger.info("Navigated to Dresses tab");
        logger.info("Check prices in Price Range field with actual on the page");

        FailInfo result = dressesPage.checkMinMaxPrice(dressesPage.pricesRange, dressesPage.prices);

        assertEquals(0, result.getCount(), "Count of failed tests:" + result.getCount() + "\n" + result.getInfo());

        logger.info("Test checkPrice finished");
    }

    @AfterAll
    public static void shutDownDriver() {
        driver.quit();
    }
}
