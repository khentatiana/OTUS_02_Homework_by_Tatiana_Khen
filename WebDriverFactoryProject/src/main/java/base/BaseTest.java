package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import manager.DriverType;
import manager.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;


// abstract make BaseTest to be inherited by outside classes, not make any changes.
public abstract class BaseTest {

   protected static WebDriver driver;
   protected static Logger logger = LogManager.getLogger(BaseTest.class);


    @BeforeMethod
    protected void oneTimeSetUp(){
        //if WebDriverFactory return driver == null. Chrome is a default
            String browser = System.getProperty("browser").toUpperCase();
            logger.info("Browser name is {}", browser);
            System.out.println("======Browser name is " + browser + "======");
            if (DriverType.valueOf(browser) == DriverType.CHROME | DriverType.valueOf(browser) == DriverType.FIREFOX
            | DriverType.valueOf(browser) == DriverType.HEADLESS) {
                driver = WebDriverFactory.createNewDriver(DriverType.valueOf(browser));
                logger.info("{} driver is created ", browser);
                System.out.println("======New driver " + browser + " is created======");
            }
            else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                logger.info("{} driver is NOT identified ", browser);
                System.out.println("======CHROME driver instead of " + browser + " is created======");
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            String browser = System.getProperty("browser").toUpperCase();
            driver.quit();
            System.out.println("=========" + browser + " browser is closed=====");
            logger.info("====={} browser is closed=====", browser);
        }
    }

}