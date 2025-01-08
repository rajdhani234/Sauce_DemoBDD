package PageLayer;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;
import UtilsLayer.ScrollUtils;

public class CartPage extends BaseClass {
    private WebDriverWait wait;
    private ScrollUtils scrollUtils;

    // Locators for Cart and Checkout buttons
    private By cartButton = By.xpath("//a[@class='shopping_cart_link']");
    private By checkoutButton = By.id("checkout");

    // Constructor: Inherit driver from BaseClass and initialize WebDriverWait and ScrollUtils
    public CartPage() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initialize WebDriverWait
        this.scrollUtils = new ScrollUtils(driver); // Initialize ScrollUtils
    }

    // Method to click on the cart icon
    public void clickOnCart() {
        int retries = 3; // Number of retries for scrolling and clicking
        boolean isClicked = false;

        while (retries > 0 && !isClicked) {
            try {
                // Attempt to locate and click the cart button
                WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(cartButton));
                cartBtn.click();
                isClicked = true; // Mark as clicked if successful
            } catch (Exception e) {
                System.err.println("Cart button not clickable, scrolling to make it visible. Retries left: " + retries);
                scrollUtils.scrollToTop(); // Scroll to the top of the page
                retries--;
            }
        }

        // Throw an exception if the button was not clicked after retries
        if (!isClicked) {
            throw new RuntimeException("Failed to click on the cart button after multiple retries.");
        }
    }

    // Method to click on the checkout button
    public void clickOnCheckOutBtn() {
        try {
            // Wait for the checkout button to be clickable
            WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
            checkoutBtn.click(); // Click the checkout button
        } catch (Exception e) {
            throw new RuntimeException("Failed to click on the checkout button.", e);
        }
    }
}
