package stepDefinations;

import org.testng.Assert;

import BaseLayer.BaseClass;
import PageLayer.CartPage;
import PageLayer.CheckoutPage;
import UtilsLayer.LoggerUtility;
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
        LoggerUtility.logInfo("Verifying user is on product page...");
        System.out.println(BaseClass.driver.getCurrentUrl());
    }

    // Scenario: User clicks the cart icon
    @When("user clicks on the cart icon")
    public void user_clicks_on_the_cart_icon() {
        LoggerUtility.logInfo("Clicking on the cart icon...");
        cartPage.clickOnCart();
    }

    // Scenario: User clicks the checkout button
    @When("user clicks on the checkout button")
    public void user_clicks_on_the_checkout_button() {
        LoggerUtility.logInfo("Clicking on the checkout button...");
        cartPage.clickOnCheckOutBtn();
    }

    // Scenario: User confirms the cart contains the correct product
    @Then("user confirms the cart contains the product {string}")
    public void user_confirms_the_cart_contains_the_product(String productName) {
        LoggerUtility.logInfo("Confirming the cart contains the product: " + productName);
        Assert.assertTrue(cartPage.isProductInCart(productName), "The cart does not contain the correct product.");
    }
}
