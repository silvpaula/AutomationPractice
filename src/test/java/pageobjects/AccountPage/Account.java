package pageobjects.AccountPage;

import frameworks.tests.BasePage;
import frameworks.report.Report;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Account extends BasePage {
    private AccountMap accountMap;

    private Account(WebDriver driver) {
        super(driver);
        this.accountMap = new AccountMap();
    }

    public static Account of(WebDriver driver) {
        return new Account(driver);
    }

    //region Web Elements
    private By AccountLabel(){
      return By.xpath(AccountMap.ACCOUNT_LABEL);
    }
    private By SignOutButton(){
        return By.className(accountMap.SIGN_OUT_BUTTON);
    }
    //endregion

    //region Actions
    public Account validateLogin() throws IOException {
        waitForElement(AccountLabel());
        highlightElement(AccountLabel());
        WebElement label = driver.findElement(AccountLabel());
        try {
            Assert.assertEquals("MY ACCOUNT", label.getText().toUpperCase());
            Report.logTestPass("Login was successful");
        } catch(ComparisonFailure e) {
            Report.logTestFailure(driver, "Login was not successful");
            throw new ComparisonFailure(e.getMessage(), e.getExpected(), e.getActual());
        }
        return this;
    }
    public Account clickSignOutButton(){
        click(SignOutButton());
        return this;
    }
    ///endregion
}
