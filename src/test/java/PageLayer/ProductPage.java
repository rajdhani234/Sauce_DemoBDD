package PageLayer;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import BaseLayer.BaseClass;
import UtilsLayer.ScrollUtils;

public class ProductPage extends BaseClass {
    private WebDriverWait wait;
    private static CartPage cartPage;

    public ProductPage() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Default timeout
        cartPage = new CartPage(); // Initialize CartPage for later use
    }

    private By productPageTitle = By.xpath("//span[@data-test='title']");

    private By addToCartButtonBy(String productName) {
        return By.id(generateAddToCartId(productName)); // Dynamic XPath generation
    }

    public boolean addProductToCartByName(String productName) {
        String productId = generateAddToCartId(productName); // Generate Add to Cart ID

        try {
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonBy(productName)));
            addToCartButton.click(); // Click the Add to Cart button
            return true; // Successfully added
        } catch (Exception e) {
            return false; // Error handling if unable to add
        }
    }

    private String generateAddToCartId(String productName) {
        return "add-to-cart-" + productName.toLowerCase().replace(" ", "-").replace("'", "");
    }

    public boolean verifyProductPage() {
        try {
            WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(productPageTitle));
            return true; // Product page loaded successfully
        } catch (Exception e) {
            return false; // Product page failed to load
        }
    }

    public void navigateToCart() {
        cartPage.clickOnCart(); // Navigate to the cart page
    }
}
