package stepDefinations;

import org.testng.Assert;

import BaseLayer.BaseClass;
import PageLayer.CartPage;
import PageLayer.LoginPage;
import PageLayer.ProductPage;
import UtilsLayer.LoggerUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonStepDefinitions {

    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;

    public CommonStepDefinitions() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
    }

    @When("user logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password) {
        LoggerUtility.logProperty("Username", username);
        LoggerUtility.logProperty("Password", password);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        LoggerUtility.logInfo("User logged in.");
    }

    @When("user adds product {string} to the cart")
    public void user_adds_product_to_cart(String productName) {
        LoggerUtility.logProperty("Product", productName);
        productPage.addProductToCartByName(productName);
        LoggerUtility.logInfo("Product added to cart.");
    }

    @Then("user verifies the product {string} is added to the cart")
    public void user_verifies_product_is_added_to_cart(String productName) {
        LoggerUtility.logInfo("Verifying the product is added to the cart.");
        Assert.assertTrue(cartPage.isProductInCart(productName), "Product not found in cart.");
    }
    

	@When("user click on menu button")
	public void user_click_on_menu_button() {
		   LoggerUtility.logInfo("Verifying click on menu ");

		loginPage.clickOnMenu();
		
	}

	@When("sideBar is open and click on logOut")
	public void side_bar_is_open_and_click_on_log_out() {
		   LoggerUtility.logInfo("Verifying the user logout.");

		loginPage.clickOnLogOut();
		BaseClass.tearDown();
	}
}
