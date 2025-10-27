package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

import java.time.Duration;

public class UIBaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.initDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.qabrains.com/ecommerce/login");
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}


