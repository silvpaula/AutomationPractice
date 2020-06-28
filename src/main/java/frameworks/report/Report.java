package frameworks.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import frameworks.constants.FrameworkConstants;
import frameworks.utils.FileManager;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class Report {
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    public static void startReport(){
        FileManager.createPath(FrameworkConstants.REPORT_FOLDER_PATH);
        htmlReporter = new ExtentHtmlReporter(FrameworkConstants.REPORT_FILE_PATH);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    public static void startTest(String testName){
        extentTest = extentReports.createTest(testName);
    }

    public static void logTestFailure(WebDriver driver, String validation) throws IOException {
        Screenshots.takeViewpointShot(driver, validation);
        extentTest.fail(validation, MediaEntityBuilder.createScreenCaptureFromPath(
                FrameworkConstants.SCREENSHOT_FILE_PATH.replace("%s", validation)).build());
    }

    public static void logTestInfo(String validation){
        extentTest.info(validation);
    }

    public static void logTestPass(String validation){
        extentTest.pass(validation);
    }

    public static void endReport(){
        extentReports.flush();
    }
}
