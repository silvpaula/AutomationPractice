package frameworks.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = (WebDriverWait) new WebDriverWait(driver, 5);
    }

    protected void waitForElement(By byElement){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byElement));
    }

    protected void click(By locator) {
        waitForElement(locator);
        highlightElement(locator);
        driver.findElement(locator).click();
    }

    public void fillString(By locator, String value){
        waitForElement(locator);
        highlightElement(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    public void switchToIframe(By locator) {
        waitForElement(locator);
        driver.switchTo().defaultContent();
        WebElement iframe = driver.findElement(locator);
        driver.switchTo().frame(iframe);
    }

    public void highlightElement(By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');",
                driver.findElement(locator));
    }
}
