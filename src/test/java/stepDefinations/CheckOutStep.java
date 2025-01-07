package stepDefinations;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;
import PageLayer.CheckoutPage;
import UtilsLayer.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckOutStep extends BaseClass {

	private CheckoutPage checkOut; // Declare the CheckoutPage object
	private Utils util; // Declare the Utils object

//	public CheckOutStep(CheckoutPage checkOut) {
//		this.checkOut = checkOut;
//	}

	@Then("user is on checkOutInfo page firstname {string} lastname {string} zip {string}")
	public void user_is_on_check_out_info_page_firstname_lastname_zip(String firstname, String lastname,
			String postalZip) {
		util = new Utils(); // Initialize the Utils object
		checkOut = new CheckoutPage(); // Initialize the CheckoutPage object

		// Enter user details in checkout fields
		checkOut.enterFirstName(firstname);
		checkOut.enterLastName(lastname);
		checkOut.enterZipCode(postalZip);
	}

	@Then("user is on checkOutInfo page")
	public void user_is_on_check_out_info_page() {
		System.out.println("User navigated to the Checkout Info Page.");
	}

	@Then("click on continue button")
	public void click_on_continue_button() {
		checkOut.clickContinueButton(); // Click on the Continue button
		System.out.println("Continue button clicked.");
	}

	@Given("User is on Checkout Overview page")
	public void user_is_on_checkout_overview_page() {
		util = new Utils(); // Initialize Utils if not already done
		String currentUrl = util.getUrl(); // Get the current URL
		System.out.println("Checkout Overview Page Current URL: " + currentUrl);
	}

	@Then("capture screenshot")
	public void capture_screenshot() throws IOException {
		util = new Utils(); // Ensure Utils is initialized
		util.fullScreenshot("saucedemo", "order"); // Capture full screenshot with name "order"
		System.out.println("Screenshot captured for order.");
	}

	@When("user click on finsh Button")
	public void user_click_on_finsh_button() {
		if (checkOut == null) {
			checkOut = new CheckoutPage(); // Initialize if null
		}
		checkOut.clickFinishButton();
	}

	@Then("show message")
	public void show_message() {
		if (checkOut == null) {
			checkOut = new CheckoutPage(); // Initialize if null
		}
		checkOut.clickFinishButton();

		String successMessage = checkOut.getSuccessMessage(); // Fetch success message
		System.out.println("Order Success Message: " + successMessage);

		driver.findElement(By.id("finish")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='complete-header']")));
		String orderConfirmation = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
		System.out.println("Order Confirmation Message: " + orderConfirmation);

	}

}
