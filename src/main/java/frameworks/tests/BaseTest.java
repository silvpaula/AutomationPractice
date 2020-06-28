package frameworks.tests;

import frameworks.report.Report;
import frameworks.utils.DriverType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import static frameworks.utils.DriverManagerFactory.quitDriver;
import static frameworks.utils.DriverManagerFactory.setDriver;

public class BaseTest {
    protected static WebDriver driver;

    private static void getDriver() {
        driver = setDriver(DriverType.CHROME);
    }

    @BeforeClass
    public static void initialize(){
        getDriver();
        driver.manage().window().maximize();
        Report.startReport();
    }

    @AfterClass
    public static void tearDown(){
        quitDriver();
        Report.endReport();
    }

}
