package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;


public class HomePageTest extends BaseTest {
    // Without Page Object Model
    @Test
    public void testCase1() {
        driver().get("https://www.google.com/");
        driver().manage().window().maximize();
        driver().findElement(By.name("q")).sendKeys("covid-19");
        driver().findElement(By.name("q")).submit();
        String pageUrl = driver().getCurrentUrl();
        Assert.assertEquals(pageUrl.startsWith("https://www.google.com/search"), "Page url  " +
                driver().getCurrentUrl() + " is NOT starts with https://www.google.com/search");

    }

    //With Page Object Model
//    @Test
//    public void testCase2(){
//        driver().get("https://www.google.com/");
//        // create object of HomePage
//        HomePage homePage = new HomePage();
//        //homePage object is created, but the elements of this page are not initialized yet.
//        //Initialize the WebElements for homePage
//        PageFactory.initElements(driver(), homePage);
//        // perform method on the page
//        homePage.searchTest("maven");
//    }
    // testCase3 is the same as testCase1, but using Page Object Model
    @Test
    public void testCase3() {
        driver().get("https://www.google.com/");
        // create object of HomePage and initialize the WebElements for homePage as one line
        HomePage homePage = PageFactory.initElements(driver(), HomePage.class);
        // perform method on the page
        homePage.searchTest("selenium");
        String expectedStartUrl = driver().getCurrentUrl();
        Assert.assertTrue(homePage.getHomePageUrl().startsWith(expectedStartUrl), "=====Page url  " +
                driver().getCurrentUrl() + " is NOT starts with https://www.google.com/search======");
    }

    @Test
    public void performSearch() {
        driver().get("https://www.google.com/");
        HomePage homePage = PageFactory.initElements(driver(), HomePage.class);
        String inputSearchText = "maven";
        homePage.searchTest(inputSearchText);
        Assert.assertTrue(homePage.getSearchedText() == inputSearchText, "======Searched text " + inputSearchText +
                "is NOT the same as " + homePage.getSearchedText() + " which is input in searched line.=====");

    }

    @Test
    public void titleTest() {
        String url = "https://www.google.com/";
        driver().get(url);
        HomePage homePage = PageFactory.initElements(driver(), HomePage.class);
        String title = homePage.getHomePageTitle();
        Assert.assertTrue(title == "Google", "====Title of the page is NOT \"Google\"====");

    }

    @Test
    public void resultPageTitle() {
        String url = "https://www.google.com/";
        String inputSearchText = "covid-19";
        String expectedResultPageTitle = "Google Search";
        driver().get(url);
        HomePage homePage = PageFactory.initElements(driver(), HomePage.class);
        homePage.searchTest(inputSearchText);
        SearchResultsPage resultPage = homePage.redirectSearchTest(inputSearchText);
        String resultPageTitle = resultPage.getTitle();
         Assert.assertTrue(resultPageTitle.contains(expectedResultPageTitle),
                "=======Title of the page is NOT \"Google Search\"=====");
    }

    @Test
    public void resultPageUrl() {
        String url = "https://www.google.com/";
        String inputSearchText = "Computer";
        String expectedResultPageUrlBegin = "https://www.google.com/search";
        driver().get(url);
        HomePage homePage = PageFactory.initElements(driver(), HomePage.class);
        homePage.searchTest(inputSearchText);
        SearchResultsPage resultPage = homePage.redirectSearchTest(inputSearchText);
        String resultPageUrl = driver().getCurrentUrl();
        Assert.assertTrue(resultPage.getUrl().startsWith(expectedResultPageUrlBegin),
                "=======ResultPage url " + resultPageUrl + "is NOT starting with " + expectedResultPageUrlBegin
                        + "=====");
    }
    @Test
    public void openHomePage(){
        String expectedHomePageUrl = "https://www.google.com/";
        HomePage homePage = PageFactory.initElements(driver(), HomePage.class);
        homePage.openWebPage("https://www.google.com/");
        String actualHomePageUrl = homePage.getUrl();
        Assert.assertTrue(expectedHomePageUrl == actualHomePageUrl, "=======Opened page url "+
                actualHomePageUrl + " is NOT matching expected url " + expectedHomePageUrl + "=====");
    }
}