package workflows;

import frameworks.tests.BasePage;
import org.openqa.selenium.WebDriver;
import pageobjects.AccountPage.Account;
import pageobjects.HomePage.Home;
import pageobjects.LoginPage.Login;
import utils.CRUD.User;

import java.io.IOException;

public class Workflow extends BasePage {
    private Workflow(WebDriver driver){
        super(driver);
    }
    public static Workflow of(WebDriver driver){
        return new Workflow(driver);
    }

    //region Flow
    public void validateLoginWithSuccess(User user) throws IOException {
        login(user);
        Account.of(driver)
                .validateLogin()
                .clickSignOutButton();
    }
    //endregion

    //region Helpers
    private void login(User user){
        Home.of(driver)
                .goToURL()
                .clickLoginButton();
        Login.of(driver)
                .fillEmailField(user.getEmail())
                .fillPasswordField(user.getPassword())
                .clickLoginButton();
    }
    //endregion
}
