package PageLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import BaseLayer.BaseClass;
import UtilsLayer.ScrollUtils;

public class CartPage extends BaseClass {
	private WebDriverWait wait;
	private ScrollUtils scrollUtils;

	// Locators for Cart and Checkout buttons
	private By cartButton = By.xpath("//a[@class='shopping_cart_link']");
	private By checkoutButton = By.id("checkout");

	private static final Logger logger = LoggerFactory.getLogger(CartPage.class); // Logger instance

	// Constructor: Initialize WebDriverWait and ScrollUtils
	public CartPage() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initialize WebDriverWait
		this.scrollUtils = new ScrollUtils(driver); // Initialize ScrollUtils
	}

	// Method to click on the cart icon
	public void clickOnCart() {
		int retries = 3; // Number of retries for scrolling and clicking
		boolean isClicked = false;

		logger.info("Attempting to click on the cart button.");

		while (retries > 0 && !isClicked) {
			try {
				// Ensure the cart button is clickable
				WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(cartButton));
				cartBtn.click(); // Attempt to click the cart button
				isClicked = true;
				logger.info("Cart button clicked successfully.");
			} catch (Exception e) {
				// Log and scroll to make the element visible
				logger.warn("Cart button not clickable. Retrying... Remaining retries: {}", retries);
				scrollUtils.scrollToTop(); // Scroll to make it visible
				retries--;
			}
		}

		if (!isClicked) {
			logger.error("Failed to click on the cart button after multiple retries.");
			throw new RuntimeException("Failed to click on the cart button after multiple retries.");
		}
	}

	// Method to click on the checkout button
	public void clickOnCheckOutBtn() {
		logger.info("Attempting to click on the checkout button.");

		try {
			// Wait until the checkout button is clickable
			WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
			checkoutBtn.click(); // Attempt to click the checkout button
			logger.info("Checkout button clicked successfully.");
		} catch (Exception e) {
			logger.error("Failed to click on the checkout button.", e);
			throw new RuntimeException("Failed to click on the checkout button.");
		}
	}

	// Method to verify if the checkout page is displayed after clicking checkout
	// button
	public boolean isCheckoutPageDisplayed() {
		logger.info("Verifying if the checkout page is displayed.");

		try {
			WebElement checkoutPageElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_title")));
			boolean isDisplayed = checkoutPageElement.isDisplayed();
			logger.info("Checkout page visibility status: {}", isDisplayed);
			return isDisplayed;
		} catch (Exception e) {
			logger.error("Checkout page is not displayed.", e);
			return false;
		}
	}

	// Method to verify if the cart contains products
	public boolean isProductInCart(String productName) {
		logger.info("Checking if product '{}' is in the cart.", productName);

		try {
			By productLocator = By.xpath(
					"//div[@class='cart_item']//div[@class='inventory_item_name'][text()='" + productName + "']");
			WebElement productInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator));
			boolean isProductDisplayed = productInCart.isDisplayed();
			logger.info("Product '{}' found in cart: {}", productName, isProductDisplayed);
			return isProductDisplayed;
		} catch (Exception e) {
			logger.error("Product '{}' not found in the cart.", productName, e);
			return false; // Product not found in the cart
		}
	}
}
