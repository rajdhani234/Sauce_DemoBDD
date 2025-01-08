package BaseLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import UtilsLayer.LoggerUtility;

public class BaseClass {
	public static WebDriver driver;

	// Initialize WebDriver and open the Sauce Demo login page
	public static void initialization(String browser) {
		String environment = System.getenv("ENVIRONMENT"); // Fetch environment variable

		LoggerUtility.logInfo("Initializing WebDriver...");

		// Log browser property
		LoggerUtility.logProperty("Browser", browser);

		// Setup WebDriver
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			LoggerUtility.logInfo("Chrome browser initialized.");
		} else {
			LoggerUtility.logError("Unsupported browser: " + browser);
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		// Log environment property
		LoggerUtility.logProperty("Environment", environment);

		String baseUrl = "https://www.saucedemo.com"; // Default to Sauce Demo
		if ("staging".equalsIgnoreCase(environment)) {
			baseUrl = "https://staging.saucedemo.com"; // Example for staging URL
			LoggerUtility.logInfo("Running in Staging environment.");
		} else if ("production".equalsIgnoreCase(environment)) {
			baseUrl = "https://www.saucedemo.com"; // Example for production URL
			LoggerUtility.logInfo("Running in Production environment.");
		} else {
			LoggerUtility.logInfo("No environment specified, defaulting to Sauce Demo.");
		}

		driver.get(baseUrl);
		LoggerUtility.logInfo("Navigated to URL: " + baseUrl);
	}

	// Close the driver after the test completes
	public static void tearDown() {
		if (driver != null) {
			LoggerUtility.logInfo("Closing WebDriver...");
			driver.quit();
			LoggerUtility.logInfo("WebDriver closed successfully.");
		} else {
			LoggerUtility.logError("WebDriver is not initialized. Skipping driver quit.");
		}
	}
}
