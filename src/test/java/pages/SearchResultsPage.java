package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {


    @FindBy(id = "searchform")
    WebElement searchField;

    @FindBy(name = "q")
    WebElement inputField;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchedText() {
        return inputField.getAttribute("value");
    }



}
