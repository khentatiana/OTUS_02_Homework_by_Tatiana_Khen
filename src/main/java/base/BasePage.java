package base;

import org.openqa.selenium.WebDriver;

// BasePage class = WebElements + common Methods used on the every web page
public class BasePage {

    private WebDriver driver;

    //public connstructor because initElement method from PageFactory call this constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver driver() {
        return driver;
    }

    public void openWebPage(String url){
       driver.get(url);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle(){
        return driver.getTitle();
        }

}

