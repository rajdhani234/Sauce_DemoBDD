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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Hooks {

	private static ExtentReports extent;
	private static ExtentTest scenarioTest;
	private static WebDriver driver;
	private static final Logger logger = LogManager.getLogger(Hooks.class); // Initialize Log4j Logger

	@Before(order = 1)
	public void setUpWebDriver() {
		// Set up WebDriver
		driver = new ChromeDriver();
		logger.info("WebDriver initialized successfully.");
	}

	@Before(order = 2)
	public void setUpExtentReports(Scenario scenario) {
		if (extent == null) {
			setupExtentReporter();
		}
		scenarioTest = extent.createTest(scenario.getName());
		logger.info("Starting test scenario: " + scenario.getName());
	}

	@After(order = 1)
	public void captureScreenshotOnFailure(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotPath = captureScreenshot(scenario.getName());
			if (screenshotPath != null) {
				scenarioTest.fail("Failed scenario: " + scenario.getName()).addScreenCaptureFromPath(screenshotPath);
				logger.error("Scenario failed: " + scenario.getName() + " - Screenshot saved at: " + screenshotPath);
			}
		} else {
			scenarioTest.pass("Scenario passed: " + scenario.getName());
			logger.info("Scenario passed: " + scenario.getName());
		}
	}

	@After(order = 2)
	public void tearDownWebDriver() {
		if (driver != null) {
			driver.quit();
			logger.info("WebDriver closed successfully.");
		}
	}

	@After(order = 3)
	public void flushExtentReports() {
		if (extent != null) {
			extent.flush();
			logger.info("Extent report flushed.");
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
		logger.info("Extent report setup completed.");
	}

	private String captureScreenshot(String scenarioName) {
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String screenshotPath = "test-output/screenshots/" + scenarioName + ".png";
			File destination = new File(screenshotPath);
			Files.copy(screenshot.toPath(), destination.toPath());
			logger.info("Screenshot captured for scenario: " + scenarioName);
			return screenshotPath;
		} catch (IOException e) {
			logger.error("Error capturing screenshot for scenario: " + scenarioName, e);
			return null;
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
