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

    // Constructor: Initialize WebDriverWait and ScrollUtils
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
                // Ensure the cart button is clickable
                WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(cartButton));
                cartBtn.click(); // Attempt to click the cart button
                isClicked = true;
                System.out.println("Cart button clicked successfully.");
            } catch (Exception e) {
                // Log and scroll to make the element visible
                System.out.println("Cart button not clickable. Retrying...");
                scrollUtils.scrollToTop(); // Scroll to make it visible
                retries--;
            }
        }

        if (!isClicked) {
            throw new RuntimeException("Failed to click on the cart button after multiple retries.");
        }
    }

    // Method to click on the checkout button
    public void clickOnCheckOutBtn() {
        try {
            // Wait until the checkout button is clickable
            WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
            checkoutBtn.click(); // Attempt to click the checkout button
            System.out.println("Checkout button clicked successfully.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to click on the checkout button.");
        }
    }

    // Method to verify if the checkout page is displayed after clicking checkout button
    public boolean isCheckoutPageDisplayed() {
        try {
            WebElement checkoutPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_title"))); // Assuming a title or header is present on the checkout page
            return checkoutPageElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to verify if the cart contains products
    public boolean isProductInCart(String productName) {
        try {
            By productLocator = By.xpath("//div[@class='cart_item']//div[@class='inventory_item_name'][text()='" + productName + "']");
            WebElement productInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator));
            return productInCart.isDisplayed();
        } catch (Exception e) {
            return false; // Product not found in the cart
        }
    }
}
