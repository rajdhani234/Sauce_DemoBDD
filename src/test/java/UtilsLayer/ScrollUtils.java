package UtilsLayer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollUtils {
    private WebDriver driver;

    // Constructor to initialize WebDriver
    public ScrollUtils(WebDriver driver) {
        this.driver = driver;
    }

    // Method to scroll upward by a specific pixel amount
    public void scrollUpByPixels(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -" + pixels + ");");
    }

    // Method to scroll upward to the top of the page
    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }

    // Method to scroll upward to a specific element
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
