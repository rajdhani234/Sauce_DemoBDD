package stepDefinations;

import java.util.concurrent.TimeoutException;

import BaseLayer.BaseClass;
import PageLayer.CartPage;
import UtilsLayer.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStep extends BaseClass {

	private Utils util; // Declare the Utils object
	private CartPage cartPage;

	@Given("user is on product page")
	public void user_is_on_product_page() {
		util = new Utils();
		cartPage = new CartPage();
		String currentUrl = util.getUrl();
		System.out.println("Cartstep Current URL: " + currentUrl);
	}

	@When("user click on cartButton")
	public void user_click_on_cart_button() {

		cartPage.clickOnCart();
	}

	@When("user click on CheckOutButton")
	public void user_click_on_check_out_button() {
		cartPage.clickOnCheckOutBtn();
	}

}
