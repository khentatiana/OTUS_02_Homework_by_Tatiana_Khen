package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    //    public static WebDriver createNewDriver(DriverType browserType) {
//
//        switch (browserType) {
//            case CHROME:
//                WebDriverManager.chromedriver().setup();
//                return new ChromeDriver();
//
//            case FIREFOX:
//                WebDriverManager.firefoxdriver().setup();
//                return new FirefoxDriver();
//
//            default:
//                return null;
//
//        }
//    }
//    public static WebDriver createNewDriver(DriverType browserType, MutableCapabilities browserOptions) {
//
//        WebDriver driver = null;
//
//        switch (browserType) {
//            case CHROME:
//                WebDriverManager.chromedriver().setup();
//                return new ChromeDriver((ChromeOptions) browserOptions);
//
//            case FIREFOX:
//                WebDriverManager.firefoxdriver().setup();
//                return new FirefoxDriver((FirefoxOptions) browserOptions);
//
//            default:
//                return null;
//        }
//    }
    public static WebDriver createNewDriver(DriverType browserName) {
        WebDriver driver = null;

        switch (browserName.toString().toUpperCase()) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();

            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            default:
            {
                System.out.println("===Invalid browser name ====");
                return null;
            }

        }
    }
    public static WebDriver createNewDriver(DriverType browserType, MutableCapabilities browserOptions) {

    WebDriver driver = null;

        switch (browserType) {
        case CHROME:
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver((ChromeOptions) browserOptions);

        case FIREFOX:
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver((FirefoxOptions) browserOptions);

        default:
            return null;
    }
}
}
