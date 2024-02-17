package frameworkDesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    WebElement UserEmail;

    @FindBy(id = "userPassword")
    WebElement UserPassword;

    @FindBy(id = "login")
    WebElement Submit;

    public ProductCatalogue loginApplication(String email, String password) {
        performSendKeys(UserEmail, email);
        performSendKeys(UserPassword, password);
        performClick(Submit);
        return new ProductCatalogue(driver);
    }

    public void goTO() {
        driver.get("https://rahulshettyacademy.com/client");
    }
}
