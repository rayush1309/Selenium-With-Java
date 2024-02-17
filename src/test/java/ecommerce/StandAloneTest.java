package ecommerce;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {
    public static void main(String[] args) {
        String productName="ADIDAS ORIGINAL";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //String productName="ADIDAS ORIGINAL";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client/");
        driver.manage().window().maximize();
        driver.findElement(By.id("userEmail")).sendKeys("rayush885@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Test@1234");
        driver.findElement(By.id("login")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
        WebElement prod = products.stream()
                .filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName))
                .findFirst()
                .orElse(null);
        prod.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[3]")).click();
        //explicit wait to capturing toaster message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));


        //ng- animating class name : for Loading : and disspearing the animating icons
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
       Boolean match= cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().
               equalsIgnoreCase(productName));
        Assert.assertTrue(match);
        //Autosuggestive Drop Down -> handle by Actions Class
        driver.findElement(By.cssSelector(".totalRow button")).click();
        Actions ac= new Actions(driver);
        //ac.sendKeys : 1st argument expecting webelemet, and 2nd what you want to type
        WebElement webElement= driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
        ac.sendKeys(webElement,"india").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
        driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']"))
                .click();
        String confirmMessage =driver.findElement(By.cssSelector(".hero-primary")).getText();
        System.out.println("message = " + confirmMessage);
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        Assert.assertEquals(confirmMessage,"THANKYOU FOR THE ORDER.");
        driver.close();










    }
}
