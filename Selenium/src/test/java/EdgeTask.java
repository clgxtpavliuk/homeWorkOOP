import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EdgeTask {

    private static WebDriver driver;
    @BeforeAll
    public static void setUp() {
        String exePath = "C:\\Windows\\System32\\MicrosoftWebDriver.exe";
        System.setProperty("webdriver.edge.driver", exePath);
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void loginTest() throws InterruptedException {
        String url = "https://en.wikipedia.org/wiki/Main_Page";
       driver.get(url);
        List<WebElement> links;
        links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        for (WebElement elem : links) {
            System.out.println("The text of the link: " + elem.getText());
        }
    }

    @AfterAll
    public static void tearDown()
    {
        driver.quit();
    }
}
