package frameworkDesign;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutPage extends AbstractComponent {
    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // initialize Elements
    @FindBy(css = "*[placeholder='Select Country']")
    WebElement country;

    By results = By.cssSelector(".ta-results");

    // action submit click on button
    @FindBy(css = ".btnn")
    WebElement submit;

    // Select Country
    @FindBy(xpath = "(//input[@type='text'])[2]")
    WebElement countryName;

    @FindBy(css = ".ta-item:nth-of-type(2)")
    WebElement selectCountry;

    public void selectCountry(String countryName) {
        Actions ac = new Actions(driver);
        ac.sendKeys(country, countryName).build().perform();
        waitElementToAppear(results);
        selectCountry.click();
    }

    public ConfirmationPage submitOrder() {
        submit.click();
        // Adding a wait for the toast message to appear after submitting the order
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        return new ConfirmationPage(driver);
    }
}
