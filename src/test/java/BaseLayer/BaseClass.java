package BaseLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BaseClass {
    protected static WebDriver driver;

    // Initialize WebDriver and open the Sauce Demo login page
    public static void initialization() {
        driver = new ChromeDriver();
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
