package BaseLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver;

	// Initialize WebDriver and open the Sauce Demo login page
	public static void initialization(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else {
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
	}

	// Close the driver after the test completes
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
