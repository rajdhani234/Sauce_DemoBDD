package PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import BaseLayer.BaseClass;

import java.time.Duration;

public class CartPage extends BaseClass {
	private WebDriverWait wait;

	// Locators for Cart and Checkout buttons
	private By cartButton = By.xpath("//a[@class='shopping_cart_link']");
	private By checkoutButton = By.id("checkout");

	// Constructor: Inherit driver from BaseClass and initialize WebDriverWait
	public CartPage() {
		// Initialize the WebDriverWait object with 30 seconds timeout
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	// Method to click on the cart icon
	public void clickOnCart() {
		WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(cartButton));
		cartBtn.click(); // Click the cart button
	}

	// Method to click on the checkout button
	public void clickOnCheckOutBtn() {
		WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
		checkoutBtn.click(); // Click the checkout button
	}
}
