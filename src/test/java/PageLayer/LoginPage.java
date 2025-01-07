package PageLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;
import UtilsLayer.ScrollUtils;

public class LoginPage extends BaseClass {
	private By usernameField = By.id("user-name");
	private By passwordField = By.id("password");
	private By loginButton = By.id("login-button");

	private By menuBtn = By.id("react-burger-menu-btn");
	private By logutLinkBtn = By.id("logout_sidebar_link");

	private WebDriverWait wait;

	public LoginPage() {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}

	public void clickOnMenu() {
		ScrollUtils scu = new ScrollUtils(driver);
		scu.scrollToTop();
		WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
		menu.click();
	}

	public void clickOnLogOut() {
		WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(logutLinkBtn));
		logoutButton.click();
	}
}
