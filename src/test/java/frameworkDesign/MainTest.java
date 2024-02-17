package frameworkDesign;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MainTest {
    public static void main(String[] args) {
        String productName = "ADIDAS ORIGINAL";

        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the landing page
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTO();
        landingPage.loginApplication("rayush885@gmail.com", "Test@1234");

        // Select a product from the catalog
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        try {
            productCatalogue.addProductToCart(productName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Wait for the success message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCatalogue.getToastMessage()));

        // Validate product added to the cart
        CartPage cartPage = new CartPage(driver);
        boolean isProductInCart = cartPage.isProductInCart(productName);
        Assert.assertTrue(isProductInCart);

        // Proceed to checkout
        CheckOutPage checkOutPage = cartPage.checkout();

        // Assuming you have methods for checkout steps in the CheckOutPage class
        checkOutPage.selectCountry("India");
        ConfirmationPage confirmationPage = checkOutPage.submitOrder();

        // ... existing code ...

        // Close the browser
        driver.quit();
    }
}
