import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FacebookTask {

    private static WebDriver driver;
    @BeforeAll
    public static void setUp() {
        String exePath = "C:\\Users\\Tetiana_Pavliuk\\My_folder\\Java\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void loginTest() throws InterruptedException {
        String url = "http://facebook.com";
        String login = "TesterJavaTraining";
        String pass = "q1w2e3r4";
        driver.get(url);
        //Thread.sleep(10000);
        WebElement submitButton = driver.findElement(By.xpath("//*[@type=\"submit\"]"));
        driver.findElement(By.id("email")).sendKeys(login);
        driver.findElement(By.id("pass")).sendKeys(pass);

        submitButton.submit();
        //Thread.sleep(10000);
        assertFalse(submitButton.isDisplayed(), "You are not log in!");

    }

    @AfterAll
    public static void tearDown()
    {
        driver.quit();
    }
}
