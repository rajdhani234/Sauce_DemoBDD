package stepDefinations;

import org.testng.Assert;
import BaseLayer.BaseClass;
import PageLayer.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginStep {

    private LoginPage loginPage;

    // Scenario: User lands on the login page
    @Given("Sauce user is on the login page")
    public void sauce_user_is_on_the_login_page() {
        BaseClass.initialization("chrome");
        loginPage = new LoginPage();
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed.");
    }

    // Scenario: User enters valid credentials
    @When("user enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    // Scenario: User clicks on the login button
    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.clickLoginButton();
    }
}
