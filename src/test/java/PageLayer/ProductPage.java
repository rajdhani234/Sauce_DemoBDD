package PageLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import BaseLayer.BaseClass;

public class ProductPage extends BaseClass {
    private WebDriverWait wait;
    private static CartPage cartPage;
    
    private static final Logger logger = LoggerFactory.getLogger(ProductPage.class); // Logger instance

    public ProductPage() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        cartPage = new CartPage();
    }

    private By productPageTitle = By.xpath("//span[@data-test='title']");

    private By addToCartButtonBy(String productName) {
        return By.id(generateAddToCartId(productName));
    }

    public boolean addProductToCartByName(String productName) {
        logger.info("Attempting to add product '{}' to the cart.", productName); // Log message

        String productId = generateAddToCartId(productName);

        try {
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonBy(productName)));
            addToCartButton.click();
            logger.info("Product '{}' added to the cart successfully.", productName); // Success log
            return true;
        } catch (Exception e) {
            logger.error("Failed to add product '{}' to the cart. Error: {}", productName, e.getMessage()); // Error log
            return false;
        }
    }

    private String generateAddToCartId(String productName) {
        return "add-to-cart-" + productName.toLowerCase().replace(" ", "-").replace("'", "");
    }

    public boolean verifyProductPage() {
        logger.info("Verifying product page visibility.");

        try {
            WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(productPageTitle));
            logger.info("Product page loaded successfully.");
            return true;
        } catch (Exception e) {
            logger.error("Product page failed to load. Error: {}", e.getMessage());
            return false;
        }
    }

    public void navigateToCart() {
        logger.info("Navigating to the cart page.");
        cartPage.clickOnCart();
    }
}
