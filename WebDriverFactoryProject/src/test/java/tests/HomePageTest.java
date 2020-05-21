package tests;

import base.BaseTest;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {

    String url = "https://otus.ru/";
    @Test
    public void openHomePage(){
        driver.get(url);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("The HOME page URL is:");
        System.out.println("======" + currentUrl + "======");
        System.out.println();
        logger.info("Opened url {}", currentUrl );
        String title = driver.getTitle();
        System.out.println("The HOME page title is:");
        System.out.println("======" + title + "======");
        System.out.println();
        logger.info("Title of opened url {}", title );

    }
}