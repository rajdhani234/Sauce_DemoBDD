package PageLayer;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import BaseLayer.BaseClass;

public class CheckoutPage extends BaseClass {
    // Locators for checkout page elements
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By message = By.xpath("//h2[@class='complete-header']");

    // WebDriverWait for element synchronization
    private WebDriverWait wait;

    public CheckoutPage() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Method to wait for an element to be visible
    private WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Methods to interact with the checkout form fields
    public void enterFirstName(String firstName) {
        WebElement firstNameElement = waitForElementToBeVisible(firstNameField);
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameElement = waitForElementToBeVisible(lastNameField);
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
    }

    public void enterZipCode(String zipCode) {
        WebElement zipCodeElement = waitForElementToBeVisible(zipCodeField);
        zipCodeElement.clear();
        zipCodeElement.sendKeys(zipCode);
    }

    // Method to fill in shipping information
    public void enterShippingInformation(String firstName, String lastName, String zipCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterZipCode(zipCode);
    }

    // Method to click continue button and wait for the next page
    public void clickContinueButton() {
        WebElement continueBtn = waitForElementToBeVisible(continueButton);
        continueBtn.click();
        wait.until(ExpectedConditions.urlContains("checkout-step-two"));
    }

    // Method to click finish button and verify success message
    public void clickFinishButton() {
        WebElement finishBtn = waitForElementToBeVisible(finishButton);
        finishBtn.click();
    }

    // Method to get the success message after completing the checkout
    public String getSuccessMessage() {
        WebElement successMessage = waitForElementToBeVisible(message);
        return successMessage.getText();
    }

	
}
