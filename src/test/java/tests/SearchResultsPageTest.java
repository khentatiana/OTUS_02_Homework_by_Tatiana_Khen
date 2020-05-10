package tests;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

public class SearchResultsPageTest extends BaseTest {

         @Test
      public void searchTextMatchingTest() {
          String homePageUrl = "https://www.google.com/";
          String inputText = "Facebook";
          driver().get(homePageUrl);
          HomePage homePage = PageFactory.initElements(driver(), HomePage.class);
          homePage.searchTest(inputText);
          SearchResultsPage resultPage = PageFactory.initElements(driver(), SearchResultsPage.class);
          String actualSearchText = resultPage.getSearchedText();
          Assert.assertEquals(inputText == actualSearchText, "====Input text" + inputText
                  + "from HomePage is NOT matching searched text" + actualSearchText + "from ResultPage");

        }
    }

