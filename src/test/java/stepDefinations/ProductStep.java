package stepDefinations;

import BaseLayer.BaseClass;
import PageLayer.CartPage;
import PageLayer.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStep extends BaseClass {
    private ProductPage productPage;
    private CartPage cartPage;

    @Given("user is on the product page")
    public void user_is_on_the_product_page() {
        productPage = new ProductPage();
        cartPage = new CartPage();
    }

    @Then("user validates the product page URL")
    public void user_validates_the_product_page_url() {
        System.out.println("Current URL: " + driver.getCurrentUrl());
    }

    @Then("user validates the product page title")
    public void user_validates_the_product_page_title() {
        System.out.println("Page Title: " + driver.getTitle());
    }

    @Then("adds {string} to the cart by clicking on the Add to Cart button")
    public void adds_to_the_cart_by_clicking_on_the_add_to_cart_button(String productName) {
        productPage.addProductToCartByName(productName);
    }

   
}
