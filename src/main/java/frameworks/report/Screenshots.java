package frameworks.report;

import frameworks.constants.FrameworkConstants;
import frameworks.utils.FileManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Screenshots {
    public static void takeViewpointShot (WebDriver driver, String nomeMetodo) {
        TakesScreenshot srcShot = (TakesScreenshot) driver;
        File srcFile = srcShot.getScreenshotAs(OutputType.FILE);

        try {
            FileManager.createPath(FrameworkConstants.SCREENSHOT_FOLDER_PATH);
            FileUtils.copyFile(srcFile, new File(FrameworkConstants.SCREENSHOT_FILE_PATH
                    .replace("%s", nomeMetodo)));

        } catch (IOException e) {
            System.out.println("Não foi possível capturar a tela");
            e.printStackTrace();
        }
    }

    public static void takeFullPageShot(WebDriver driver, String nomeMetodo) {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(
                1000)).takeScreenshot(driver);

        try {
            FileManager.createPath(FrameworkConstants.SCREENSHOT_FOLDER_PATH);
            ImageIO.write(screenshot.getImage(),"PNG",new File(FrameworkConstants.
                    SCREENSHOT_FILE_PATH.replace("%s", nomeMetodo)));

        } catch (IOException e) {
            System.out.println("Não foi posssível capturar a tela");
            e.printStackTrace();

        }
    }

}
