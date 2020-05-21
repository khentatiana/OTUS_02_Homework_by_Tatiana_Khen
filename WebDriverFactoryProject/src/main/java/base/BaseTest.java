package base;

import manager.DriverType;
import manager.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;


// abstract make BaseTest to be inherited by outside classes, not make any changes.
public abstract class BaseTest {

   protected static WebDriver driver;
   protected static Logger logger = LogManager.getLogger(BaseTest.class);


    @BeforeMethod
    protected void oneTimeSetUp(){

        String browser = System.getProperty("browser").toUpperCase();
        logger.info("Browser name is {}", browser);
        System.out.println("======Browser name is " + browser +"======");
        driver = WebDriverFactory.createNewDriver(DriverType.valueOf(browser));
        logger.info("{} driver is created ", browser);
        System.out.println("======New driver " + browser +" is created======");
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