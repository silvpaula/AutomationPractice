package pageobjects.LoginPage;

import frameworks.tests.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BasePage {
    private LoginMap loginMap;

    private Login(WebDriver driver) {
        super(driver);
        this.loginMap = new LoginMap();
    }

    public static Login of(WebDriver driver) {
        return new Login(driver);
    }

    //region Web Elements
    private By EmailField() {
        return By.id(loginMap.EMAIL_FIELD);
    }

    private By PasswordField() {
        return By.name(loginMap.PASSWORD_FIELD);
    }

    private By SubmitButton() {
        return By.cssSelector(loginMap.SUBMIT_BUTTON);
    }
    //endregion

    //region Actions

    public Login fillEmailField(String email){
        fillString(EmailField(),email);
        return this;
    }

    public Login fillPasswordField(String password){
        fillString(PasswordField(),password);
        return this;
    }

    public Login clickLoginButton() {
        click(SubmitButton());
        return this;
    }

    //endregion
}