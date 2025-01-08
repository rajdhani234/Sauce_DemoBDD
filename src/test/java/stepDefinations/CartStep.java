package stepDefinations;

import org.testng.Assert;

import BaseLayer.BaseClass;
import PageLayer.CartPage;
import PageLayer.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStep {

	private CartPage cartPage;
	private CheckoutPage checkoutPage;

	public CartStep() {
		cartPage = new CartPage();
		checkoutPage = new CheckoutPage();
	}

	@Given("user is on product page")
	public void user_is_on_product_page() {
		System.out.println(BaseClass.driver.getCurrentUrl());
	}

	// Scenario: User clicks the cart icon
	@When("user clicks on the cart icon")
	public void user_clicks_on_the_cart_icon() {
		cartPage.clickOnCart();
	}

	// Scenario: User clicks the checkout button
	@When("user clicks on the checkout button")
	public void user_clicks_on_the_checkout_button() {
		cartPage.clickOnCheckOutBtn();
	}

	// Scenario: User confirms the cart contains the correct product
	@Then("user confirms the cart contains the product {string}")
	public void user_confirms_the_cart_contains_the_product(String productName) {
		Assert.assertTrue(cartPage.isProductInCart(productName), "The cart does not contain the correct product.");
	}
}
