// package stepDefinations;

// import java.io.IOException;

// import org.testng.Assert;

// import PageLayer.CheckoutPage;
// import UtilsLayer.LoggerUtility;
// import UtilsLayer.Utils;
// import io.cucumber.java.en.Given;
// import io.cucumber.java.en.Then;
// import io.cucumber.java.en.When;

// public class CheckoutStep {

// 	private CheckoutPage checkoutPage;
// 	private Utils util;

// 	public CheckoutStep() {
// 		checkoutPage = new CheckoutPage();
// 		util = new Utils();
// 	}

// 	// Scenario: User provides shipping information
// 	@When("user is on checkOutInfo page firstname {string} lastname {string} zip {string}")
// 	public void user_is_on_check_out_info_page_firstname_lastname_zip(String firstName, String lastName,
// 			String zipCode) {
// 		LoggerUtility.logProperty("First Name", firstName);
// 		LoggerUtility.logProperty("Last Name", lastName);
// 		LoggerUtility.logProperty("Zip Code", zipCode);
// 		checkoutPage.enterShippingInformation(firstName, lastName, zipCode);
// 		LoggerUtility.logInfo("Shipping information entered.");
// 	}

// 	@Then("click on continue button")
// 	public void click_on_continue_button() {
// 		LoggerUtility.logInfo("Clicking on continue button...");
// 		checkoutPage.clickContinueButton();
// 	}

// 	@Given("User is on Checkout Overview page")
// 	public void user_is_on_checkout_overview_page() {
// 		LoggerUtility.logInfo("User is on Checkout Overview page.");
// 	}

// 	@Then("capture screenshot")
// 	public void capture_screenshot() throws IOException {
// 		LoggerUtility.logInfo("Capturing screenshot...");
// 		util.fullScreenshot("saucedemo", "order");
// 	}

// 	// Scenario: User confirms the order
// 	@When("user click on finish Button")
// 	public void user_click_on_finish_button() {
// 		LoggerUtility.logInfo("Clicking on finish button...");
// 		checkoutPage.clickFinishButton();
// 	}

// 	// Scenario: User verifies the order completion message
// 	@Then("user should see the order confirmation message")
// 	public void user_should_see_the_order_confirmation_message() {
// 		String successMessage = checkoutPage.getSuccessMessage();
// 		LoggerUtility.logInfo("Order completion message: " + successMessage);
// 		Assert.assertEquals(successMessage, "Thank you for your order!\r\n"
// 				+ "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
// 	}
// }
