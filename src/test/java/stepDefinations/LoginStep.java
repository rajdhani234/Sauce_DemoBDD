package stepDefinations;

import org.testng.Assert;

import BaseLayer.BaseClass;
import PageLayer.LoginPage;
import UtilsLayer.LoggerUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginStep {

	private LoginPage loginPage;

	// Scenario: User lands on the login page
	@Given("Sauce user is on the login page")
	public void sauce_user_is_on_the_login_page() {
		LoggerUtility.logInfo("Initializing WebDriver and navigating to login page...");
		BaseClass.initialization("chrome");
		loginPage = new LoginPage();
		Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed.");
		LoggerUtility.logInfo("Login page displayed successfully.");
	}

	// Scenario: User enters valid credentials
	@When("user enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
		LoggerUtility.logProperty("Username", username);
		LoggerUtility.logProperty("Password", password);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		LoggerUtility.logInfo("Entered username and password.");
	}

	// Scenario: User clicks on the login button
	@When("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
		LoggerUtility.logInfo("Clicking on the login button...");
		loginPage.clickLoginButton();
	}
}
