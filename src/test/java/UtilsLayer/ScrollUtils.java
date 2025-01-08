package UtilsLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollUtils {
    private WebDriver driver;

    // Constructor to initialize WebDriver
    public ScrollUtils(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver cannot be null.");
        }
        this.driver = driver;
    }

    // Method to scroll upward by a specific pixel amount
    public void scrollUpByPixels(int pixels) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, -" + pixels + ");");
        } catch (Exception e) {
            System.err.println("Error during scrolling up by pixels: " + e.getMessage());
        }
    }

    // Method to scroll upward to the top of the page
    public void scrollToTop() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 0);");
        } catch (Exception e) {
            System.err.println("Error during scrolling to the top of the page: " + e.getMessage());
        }
    }

    // Method to scroll upward to a specific element identified by a locator
    public void scrollToElement(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            System.err.println("Error during scrolling to the element: " + e.getMessage());
        }
    }
}
