package anhtest.com.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;


public class BaseTest {
    //Khoi tao 1 browser voi Chrome
    public WebDriver driver;
    @BeforeTest
    public void createBrowser() throws Exception {
        System.out.println("Start Chrome browser... from BaseTest");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }
    @AfterTest
    public void closeBrowser() {
        System.out.println("Close Chrome browser... from BaseTest");
        driver.quit();
    }
}
