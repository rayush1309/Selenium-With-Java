package frameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends AbstractComponent {

    WebDriver driver;

    @FindBy(css = ".cartSection h3")
    private List<WebElement> cartProducts;

    @FindBy(css = ".totalRow button")
    WebElement checkoutButton;

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartHeader;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isProductInCart(String productName) {
        System.out.println("Cart Products");
        waitElementToAppear(cartHeader);  // Adding wait for the cart header
        return cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
    }

    public CheckOutPage checkout() {
        waitElementToAppear(checkoutButton);  // Adding wait for the checkout button
        checkoutButton.click();
        return new CheckOutPage(driver);
    }
}
