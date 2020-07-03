package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.DressesPage;
import pageobject.StorePage;
import pageobject.WomenPage;
import utils.FailInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Patterns_HomeTask1 {
    private static WebDriver driver = new ChromeDriver();

    @Test
    public void checkColorWomen() throws InterruptedException {

        StorePage storePage = new StorePage(driver);
        WomenPage womenPage = storePage.goToWomen();

        FailInfo result = womenPage.compareColor(womenPage.colors, womenPage.dressesColor);

        assertEquals(0, result.getCount(), "Count of failed tests:" + result.getCount() + "\n" + result.getInfo());
    }

    @Test
    public void checkColorDresses() throws InterruptedException {

        StorePage storePage = new StorePage(driver);
        DressesPage dressesPage = storePage.goToDresses();

        FailInfo result = dressesPage.compareColor(dressesPage.colors, dressesPage.dressesColor);

        assertEquals(0, result.getCount(), "Count of failed tests:" + result.getCount() + "\n" + result.getInfo());
    }

    @AfterAll
    public static void shutDownDriver() {
        driver.quit();
    }
}
