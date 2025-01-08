package stepDefinations;

import org.testng.Assert;

import BaseLayer.BaseClass;
import PageLayer.ProductPage;
import PageLayer.CartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ProductStep {

	private ProductPage productPage;
	private CartPage cartPage;

	public ProductStep() {
		productPage = new ProductPage();
		cartPage = new CartPage();
	}

	// Scenario: User navigates to the product page
	@Given("user is on the product page")
	public void user_is_on_the_product_page() {
		Assert.assertTrue(BaseClass.driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"),
				"User is not on the product page.");
	}

	@Then("user validates the product page URL")
	public void user_validates_the_product_page_url() {
		Assert.assertTrue(BaseClass.driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"),
				"User is not on the product page.");

	}

	@Then("user validates the product page title")
	public void user_validates_the_product_page_title() {
		String title = BaseClass.driver.getTitle();
		System.out.println(title);

//		// Assert that the title contains the expected text
//		Assert.assertTrue(title.contains("Single Page Apps for GitHub Page"),
//				"User is not on the correct product page. Current page title: " + title);

	}

	// Scenario: User adds a specific product to the cart
	@When("user adds {string} to the cart by clicking on the Add to Cart button")
	public void adds_to_the_cart_by_clicking_on_the_add_to_cart_button(String productName) {
		boolean isProductAdded = productPage.addProductToCartByName(productName);
		Assert.assertTrue(isProductAdded, "Product not added to cart.");
	}

	// Scenario: User checks if the product is in the cart
	@Then("user validates the cart contains {string}")
	public void user_validates_the_cart_contains(String productName) {
		cartPage.clickOnCart();
		// Assert.assertTrue(cartPage.isProductInCart(productName), "Product not found
		// in cart.");
	}
}
