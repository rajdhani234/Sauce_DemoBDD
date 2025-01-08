package UtilsLayer;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Hooks {

    private static ExtentReports extent;
    private static ExtentTest scenarioTest;
    private static WebDriver driver;

    @Before(order = 1)
    public void setUpWebDriver() {
    }

    @Before(order = 2)
    public void setUpExtentReports(Scenario scenario) {
        if (extent == null) {
            setupExtentReporter();
        }
        scenarioTest = extent.createTest(scenario.getName());
    }

    @After(order = 1)
    public void captureScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotPath = captureScreenshot(scenario.getName());
            if (screenshotPath != null) {
                scenarioTest.fail("Failed scenario: " + scenario.getName())
                        .addScreenCaptureFromPath(screenshotPath);
            }
        } else {
            scenarioTest.pass("Scenario passed: " + scenario.getName());
        }
    }

    @After(order = 2)
    public void tearDownWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @After(order = 3)
    public void flushExtentReports() {
        if (extent != null) {
            extent.flush();
        }
    }

    private static void setupExtentReporter() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/spark-report/automation-report.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // System Info
        extent.setSystemInfo("User", "John Doe");
        extent.setSystemInfo("Build", "1.0.0");
        extent.setSystemInfo("Application", "SauceDemo Automation");
    }

    private String captureScreenshot(String scenarioName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "test-output/screenshots/" + scenarioName + ".png";
            File destination = new File(screenshotPath);
            Files.copy(screenshot.toPath(), destination.toPath());
            return screenshotPath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
