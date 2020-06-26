import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SeleniumWebDriver_HomeTask5_1 {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException, IOException {

        String url = "http://demoqa.com/tool-tips";
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement button = driver.findElement(By.xpath("//*[@id=\"toolTipButton\"]"));
        WebElement field = driver.findElement(By.xpath("//*[@id=\"toolTipTextField\"]"));
        WebElement contrary = driver.findElement(By.xpath("//*[@id=\"texToolTopContainer\"]/a[1]"));
        WebElement numbers = driver.findElement(By.xpath("//*[@id=\"texToolTopContainer\"]/a[2]"));

        Actions action = new Actions(driver);
        action.moveToElement(button).perform();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(button, "aria-describedby"));

        if (button.getAttribute("aria-describedby") != null) {
            System.out.println("Hover on button is working as defined");
        } else {
            System.out.println("Hover on button is not working as defined");
        }

        action.moveToElement(field).perform();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(field, "aria-describedby"));

        if (field.getAttribute("aria-describedby") != null) {
            System.out.println("Hover on field is working as defined");
        } else {
            System.out.println("Hover on field is not working as defined");
        }

        action.moveToElement(contrary).perform();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(contrary, "aria-describedby"));

        if (contrary.getAttribute("aria-describedby") != null) {
            System.out.println("Hover on contrary is working as defined");
        } else {
            System.out.println("Hover on contrary is not working as defined");
        }

        action.moveToElement(numbers).perform();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(numbers, "aria-describedby"));

        if (numbers.getAttribute("aria-describedby") != null) {
            System.out.println("Hover on numbers is working as defined");
        } else {
            System.out.println("Hover on numbers is not working as defined");
        }
    }

    @AfterAll
    public static void tearDown() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("SearchResult.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        driver.quit();
    }
}