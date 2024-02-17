package frameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AbstractComponent {
    WebDriver driver;

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement spinner;

    By productsBy = By.cssSelector(".mb-3");
    By addProductToCart = By.xpath("(//i[@class='fa fa-shopping-cart'])[3]");
    By toastMessage = By.cssSelector("#toast-container");

    public List<WebElement> getProductList() {
        waitElementToAppear(productsBy);
        return products;
    }

    public WebElement getProductByName(String productName) {
        return getProductList().stream()
                .filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName))
                .findFirst()
                .orElse(null);
    }

    public void addProductToCart(String productName) throws InterruptedException {
        WebElement prod = getProductByName(productName);
        prod.findElement(addProductToCart).click();
        waitElementToAppear(toastMessage);
        waitForElementToDisappear(spinner);
    }

    public By getToastMessage() {
        return toastMessage;
    }
}
