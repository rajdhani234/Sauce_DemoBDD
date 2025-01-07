package stepDefinations;

import BaseLayer.BaseClass;
import PageLayer.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep extends BaseClass {

	private LoginPage loginPage;

	@Given("Sauce user is on the login page")
	public void sauce_user_is_on_the_login_page() {
		BaseClass.initialization(); // Open browser and navigate to URL
		loginPage = new LoginPage(); // Initialize LoginPage object
	}

	@When("user enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
		if (loginPage == null) {
			System.out.println("LoginPage object is not initialized!");
			loginPage = new LoginPage();
		}
		loginPage.enterUsername(username); // Enter username
		loginPage.enterPassword(password); // Enter password
	}

	@Then("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
		if (loginPage == null) {
			System.out.println("LoginPage object is not initialized!");
			loginPage = new LoginPage();
		}
		loginPage.clickLoginButton(); // Click login button
	}

	@When("user click on menu button")
	public void user_click_on_menu_buton() {
		if (loginPage == null) {
			System.out.println("Reinitializing LoginPage object...");
			loginPage = new LoginPage();
		}
		loginPage.clickOnMenu();
	}

	@When("sideBar is open and click on logOut")
	public void side_bar_is_open_and_click_on_log_out() {
		if (loginPage == null) {
			System.out.println("Reinitializing LoginPage object...");
			loginPage = new LoginPage();
		}
		loginPage.clickOnLogOut();
	}
	
	@Then("user is on loginPage")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
