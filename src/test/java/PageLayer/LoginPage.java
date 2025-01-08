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
    private By logoutLinkBtn = By.id("logout_sidebar_link");

    private WebDriverWait wait;

    public LoginPage() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Check if the login page is displayed
    public boolean isLoginPageDisplayed() {
        try {
            WebElement usernameFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
            return usernameFieldElement.isDisplayed();
        } catch (Exception e) {
            return false; // If not displayed, return false
        }
    }

    public void enterUsername(String username) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginBtnElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtnElement.click();
    }

    public void clickOnMenu() {
        ScrollUtils scu = new ScrollUtils(driver);
        scu.scrollToTop(); // Ensure the menu is visible
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        menu.click();
    }

    public void clickOnLogOut() {
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(logoutLinkBtn));
        logoutButton.click();
    }

    public boolean isLogoutLinkVisible() {
        try {
            WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLinkBtn));
            return logoutButton.isDisplayed();
        } catch (Exception e) {
            return false; // If the logout button is not visible, login failed
        }
    }
}
