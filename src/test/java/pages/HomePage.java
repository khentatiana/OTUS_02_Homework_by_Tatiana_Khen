package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {


    // HomePage class = WebElements + Method used on the HomePage
    @FindBy(name = "q")
    WebElement inputField;

    @FindBy(name = "btnk")
    WebElement buttonSearch;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchTest(String inputSearchText) {
        inputField.sendKeys(inputSearchText);
        inputField.submit();
    }

    public String getHomePageUrl() {
        return driver().getCurrentUrl();
    }

    public String getSearchedText() {
        String searchedText = inputField.getAttribute("value");
        return searchedText;

    }
    public String getHomePageTitle()
    {
        return driver().getTitle();
    }
    public SearchResultsPage redirectSearchTest(String inputSearchText){
        inputField.sendKeys(inputSearchText);
        inputField.submit();
        // create object of SearchResultPageTest
        // and initialize the WebElements for SearchResultPageTest
        return PageFactory.initElements(driver(), SearchResultsPage.class);
    }
}

