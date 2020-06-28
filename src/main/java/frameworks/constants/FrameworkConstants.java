package frameworks.constants;

import frameworks.utils.DateFormatter;

public class FrameworkConstants {
    public static final String REPORT_FOLDER_PATH = System.getProperty("user.dir") + "/target/test_reports/";
    public static final String REPORT_FILE_PATH = REPORT_FOLDER_PATH + "tests" + DateFormatter.getTime() +
            ".html";
    public static final String SCREENSHOT_FOLDER_PATH = System.getProperty("user.dir") + "/target/screenshots/";
    public static final String SCREENSHOT_FILE_PATH = SCREENSHOT_FOLDER_PATH + "%s" + DateFormatter.getTime()
            + ".jpg";
}
