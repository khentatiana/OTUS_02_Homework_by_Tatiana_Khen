package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    public static WebDriver createNewDriver(DriverType browserType) {

        switch (browserType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            case HEADLESS:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                //return new ChromeDriver(options);

            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
    }


//    public static WebDriver createNewDriver(DriverType browserType, MutableCapabilities wdOptions) {
//        switch (browserType) {
//            case CHROME:
//                WebDriverManager.chromedriver().setup();
//                return new ChromeDriver((ChromeOptions) wdOptions);
//            case FIREFOX:
//                WebDriverManager.firefoxdriver().setup();
//                return new FirefoxDriver((FirefoxOptions) wdOptions);
//            case HEADLESS:
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("headless");
//                return new ChromeDriver(options);
//        }
//        WebDriverManager.chromedriver().setup();
//        return new ChromeDriver();
//
//    }
}
