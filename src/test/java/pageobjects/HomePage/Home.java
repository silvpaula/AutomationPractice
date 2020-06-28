package pageobjects.HomePage;

import constants.AppConstants;
import frameworks.tests.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends BasePage {
    private HomeMap homeMap;

    private Home(WebDriver driver) {
        super(driver);
        this.homeMap = new HomeMap();
    }

    public static Home of(WebDriver driver){
        return new Home(driver);
    }

    //region Web Elements
    private By LoginButton() { return By.xpath(homeMap.LOGIN_BUTTON); }
    //endregion

    //region Actions
    public Home goToURL(){
        driver.navigate().to(AppConstants.BASE_URL);
        return this;
    }
    public Home clickLoginButton(){
        click(LoginButton());
        return this;
    }
    //endregion
}
