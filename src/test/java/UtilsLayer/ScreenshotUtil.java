package UtilsLayer;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "reports/screenshots/" + screenshotName + ".png";
            FileHandler.copy(src, new File(path));
            return path;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
