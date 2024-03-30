package seleniumWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitDemo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        //Fluent Wait Declaration
        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.
        /*
        Wait<WebDriver> myWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(10L))
                .ignoring(NoSuchElementException.class);

         */
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //Declaration- FluentWait

        FluentWait myWait= new FluentWait<>(driver);
        myWait.withTimeout(Duration.ofSeconds(30L));
        myWait.pollingEvery(Duration.ofSeconds(5L));
        myWait.ignoring(NoSuchElementException.class);

/*
        //usage of Elements
        WebElement userName = myWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//input[@placeholder='Username']"));
            }
        });

 */
        //usages- Fluent Wait
        WebElement userName=(WebElement) myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        //driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        userName.sendKeys("Admin");



    }
}
