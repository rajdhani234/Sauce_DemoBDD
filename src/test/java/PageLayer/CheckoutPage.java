package PageLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class CheckoutPage extends BaseClass {
	private By firstNameField = By.id("first-name");
	private By lastNameField = By.id("last-name");
	private By zipCodeField = By.id("postal-code");
	private By continueButton = By.id("continue");
	private By finishButton = By.id("finish");
	private By message =By.xpath("//h2[@class='complete-header']");

	WebDriverWait wait;

	public CheckoutPage() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	// Methods to interact with the checkout form fields
	public void enterFirstName(String firstName) {
		driver.findElement(firstNameField).sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		driver.findElement(lastNameField).sendKeys(lastName);
	}

	public void enterZipCode(String zipCode) {
		driver.findElement(zipCodeField).sendKeys(zipCode);
	}

	public void clickContinueButton() {
		driver.findElement(continueButton).click();
	}

	public void clickFinishButton() {
		driver.findElement(finishButton).click();

	}

	public String getSuccessMessage() {
		return driver.findElement(By.className("complete-header")).getText();
	}

}

