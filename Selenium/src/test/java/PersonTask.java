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
import java.util.List;
import java.util.concurrent.TimeUnit;


public class PersonTask {

    private static WebDriver driver;
    private JavascriptExecutor js = (JavascriptExecutor) driver;

    @BeforeAll
    public static void setUp() {
        String exePath = "C:\\Users\\Tetiana_Pavliuk\\My_folder\\Java\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException, IOException {

        String url = "http://demoqa.com/webtables";

        String name = "John";
        String surname = "White";
        String email = "name@example.com";
        String age = "39";
        String salary = "1000";
        String department = "IT";

        driver.get(url);

        driver.findElement(By.xpath("//*[@id=\"addNewRecordButton\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys(name);
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys(surname);
        driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"age\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"age\"]")).sendKeys(age);
        driver.findElement(By.xpath("//*[@id=\"salary\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"salary\"]")).sendKeys(salary);
        driver.findElement(By.xpath("//*[@id=\"department\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"department\"]")).sendKeys(department);

        driver.findElement(By.xpath("//*[@id=\"submit\"]")).submit();
        List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"rt-tr-group\"]"));
        for (WebElement elem : list) {
            if (name.equals(elem.findElement(By.className("rt-td")).getText())) {
                List<WebElement> list1 = elem.findElements(By.className("rt-td"));
                list1.get(list1.size() - 1).findElement(By.tagName("path")).click();
                driver.findElement(By.xpath("//*[@id=\"age\"]")).clear();
                driver.findElement(By.xpath("//*[@id=\"age\"]")).sendKeys("38");
                driver.findElement(By.xpath("//*[@id=\"submit\"]")).submit();
                //Thread.sleep(5000);

                list1.get(list1.size() - 1).findElement(By.xpath("//span[@title=\"Delete\"]")).click();
                //Thread.sleep(5000);
            }

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
