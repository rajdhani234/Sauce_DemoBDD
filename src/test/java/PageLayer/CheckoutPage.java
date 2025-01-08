package PageLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import BaseLayer.BaseClass;

public class CheckoutPage extends BaseClass {
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By message = By.xpath("//h2[@class='complete-header']");

    private WebDriverWait wait;
    
    private static final Logger logger = LoggerFactory.getLogger(CheckoutPage.class); // Logger instance

    public CheckoutPage() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private WebElement waitForElementToBeVisible(By locator) {
        logger.info("Waiting for element to be visible: {}", locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void enterFirstName(String firstName) {
        logger.info("Entering first name: {}", firstName);
        WebElement firstNameElement = waitForElementToBeVisible(firstNameField);
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        logger.info("Entering last name: {}", lastName);
        WebElement lastNameElement = waitForElementToBeVisible(lastNameField);
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
    }

    public void enterZipCode(String zipCode) {
        logger.info("Entering zip code: {}", zipCode);
        WebElement zipCodeElement = waitForElementToBeVisible(zipCodeField);
        zipCodeElement.clear();
        zipCodeElement.sendKeys(zipCode);
    }

    public void enterShippingInformation(String firstName, String lastName, String zipCode) {
        logger.info("Entering shipping information.");
        enterFirstName(firstName);
        enterLastName(lastName);
        enterZipCode(zipCode);
    }

    public void clickContinueButton() {
        logger.info("Clicking the continue button.");
        WebElement continueBtn = waitForElementToBeVisible(continueButton);
        continueBtn.click();
        wait.until(ExpectedConditions.urlContains("checkout-step-two"));
    }

    public void clickFinishButton() {
        logger.info("Clicking the finish button.");
        WebElement finishBtn = waitForElementToBeVisible(finishButton);
        finishBtn.click();
    }

    public String getSuccessMessage() {
        logger.info("Retrieving success message after checkout.");
        WebElement successMessage = waitForElementToBeVisible(message);
        return successMessage.getText();
    }
}
