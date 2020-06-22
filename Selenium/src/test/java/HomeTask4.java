import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class HomeTask4 {

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
    public void dragDrop() throws InterruptedException, IOException {

        String url = "http://demoqa.com/sortable/";

        driver.get(url);
        List <WebElement> list = driver.findElements(By.xpath("//div[@class=\"vertical-list-container mt-4\"]/div"));
        List <Integer> values = new ArrayList<Integer>();

        WebElement from = driver.findElement(By.xpath("//div[@class=\"vertical-list-container mt-4\"]/div[text() = \"Two\"]"));
        WebElement to = driver.findElement(By.xpath("//div[@class=\"vertical-list-container mt-4\"]/div[text() = \"Five\"]"));

        for (WebElement elem: list) {
            values.add(WordNumberConverter.wordToNumber(elem.getText()));
        }
        System.out.println(values);

        List tmp = new ArrayList(values);
        Collections.sort(tmp);
        if (values.equals(tmp)) {
            Actions action = new Actions(driver);
            action.dragAndDrop(from, to).build().perform();
            Thread.sleep(4000);
        }

    }

    @Test
    public void select() throws InterruptedException, IOException {

        String url = "http://demoqa.com/selectable/";

        driver.get(url);

        WebElement first = driver.findElement(By.xpath("//*[@id=\"verticalListContainer\"]/li[1]"));
        WebElement second = driver.findElement(By.xpath("//*[@id=\"verticalListContainer\"]/li[2]"));
        WebElement third = driver.findElement(By.xpath("//*[@id=\"verticalListContainer\"]/li[4]"));
        first.click();
        second.click();
        third.click();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(first.getText() + second.getText() + third.getText() + System.currentTimeMillis() + ".png"));
    }

    @Test
    public void resize() throws InterruptedException, IOException {

        String url = "http://demoqa.com/resizable/";
        driver.get(url);
        Actions actions = new Actions(driver);
        WebElement rectangle = driver.findElement(By.xpath("//*[@id=\"resizableBoxWithRestriction\"]"));
        WebElement moveRect = driver.findElement(By.xpath("//*[@id=\"resizableBoxWithRestriction\"]/span"));

        System.out.println("Size" + rectangle.getSize());

        actions.clickAndHold(moveRect).moveByOffset(100, 100).release().build().perform();

        System.out.println("Size after making bigger" + rectangle.getSize());

        actions.clickAndHold(moveRect).moveByOffset(-90, -90).release().build().perform();

        System.out.println("Size after making smaller" + rectangle.getSize());
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
