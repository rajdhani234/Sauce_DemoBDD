package PageLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;
import io.cucumber.java.en.When;

public class ProductPage extends BaseClass {
	private WebDriverWait wait;
	static CartPage cartPage;

	// Constructor: Inherit driver from BaseClass and initialize WebDriverWait
	public ProductPage() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		cartPage = new CartPage();
	}

	private By productPageTitle = By.xpath("//span[@data-test='title']"); // Example XPath, adjust accordingly

	// Add product to the cart dynamically by product name
	public void addProductToCartByName(String productName) {
		String productId = generateAddToCartId(productName);
		System.out.println("Generated Add to Cart ID: " + productId);

		try {
			WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(productId)));
			addToCartButton.click();
			System.out.println("Clicked Add to Cart for product: " + productName);
		} catch (Exception e) {
			System.out.println("Error while adding product to cart: " + e.getMessage());
		}
	}

	// Helper method to generate Add to Cart button ID
	private String generateAddToCartId(String productName) {
		return "add-to-cart-" + productName.toLowerCase().replace(" ", "-").replace("'", "");
	}

	@When("user click on cartButton")
	public void user_click_on_cart_button() {
		cartPage.clickOnCart();
	}

	public void verifyProductPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(productPageTitle));
	}
}
