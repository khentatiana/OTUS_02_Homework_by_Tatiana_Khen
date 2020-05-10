package base;

import manager.DriverType;
import manager.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


// abstract make BaseTest to be inherited by outside classes, not make any changes.
public abstract class BaseTest {

    private WebDriver driver;
    private static Logger logger = LogManager.getLogger(BaseTest.class);
    private static String browser;

    @BeforeClass
    public static void oneTimeSetUp() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/config/prop.config"));
        } catch (IOException e) {
            System.out.println("====Config file is not loaded====" + e.getMessage());
           logger.info("Config file is not loaded" + e.getMessage());

        }
        browser = prop.getProperty("browser");
        //logger.info("=====Browser is " + browser + "=====");
        }

    @BeforeMethod
    public void setUp() {
//        if (browser.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//           logger.info("Running browser is : " + browser);
//        }
//
//        else if (browser.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//            //logger.info("Running browser is : " + browser);
//
//        } else {
//            //logger.error("Wrong browser");
//        }
        String browserType = System.getProperty("browser");
        logger.info ("====Opening browser " + browserType + "=====");
        driver = WebDriverFactory.createNewDriver(DriverType.valueOf(browserType));

    }

       @AfterMethod
    public void tearDown(){
        if(driver != null)
        {
            driver.quit();
            driver = null;
            logger.info("=====Browser is" + browser + "closed=====");
        }
    }
    //protected means driver will be accessible in outside classes. Make "private WebDriver driver;" to secure driver
    protected WebDriver driver(){
        return driver;
    }
//    public void getTitle(){
//        String title = driver.getTitle();
//        logger.info("===Title of the page is " + title + "=====");
//    }
}
