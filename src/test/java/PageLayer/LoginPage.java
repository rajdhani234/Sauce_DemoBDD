package PageLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import BaseLayer.BaseClass;

public class LoginPage extends BaseClass {
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By menuBtn = By.id("react-burger-menu-btn");
    private By logoutLinkBtn = By.id("logout_sidebar_link");

    private WebDriverWait wait;
    
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class); // Logger instance

    public LoginPage() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public boolean isLoginPageDisplayed() {
        logger.info("Checking if the login page is displayed.");

        try {
            WebElement usernameFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
            boolean isDisplayed = usernameFieldElement.isDisplayed();
            logger.info("Login page display status: {}", isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            logger.error("Login page not displayed. Error: {}", e.getMessage());
            return false;
        }
    }

    public void enterUsername(String username) {
        logger.info("Entering username: {}", username);
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        logger.info("Entering password.");
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        logger.info("Clicking on the login button.");
        WebElement loginBtnElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtnElement.click();
    }

    public void clickOnMenu() {
        logger.info("Clicking on the menu button.");
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        menu.click();
    }

    public void clickOnLogOut() {
        logger.info("Logging out of the application.");
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(logoutLinkBtn));
        logoutButton.click();
    }

    public boolean isLogoutLinkVisible() {
        logger.info("Checking if logout link is visible.");

        try {
            WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLinkBtn));
            boolean isVisible = logoutButton.isDisplayed();
            logger.info("Logout link visibility: {}", isVisible);
            return isVisible;
            
        } catch (Exception e) {
            logger.error("Logout link not visible. Error: {}", e.getMessage());
            return false;
        }
    }
}
