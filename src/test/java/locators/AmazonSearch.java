package locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.time.Duration;

public class AmazonSearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        // Wait for the element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountList = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-accountList")));

        // Perform actions on the element
        actions.moveToElement(accountList).perform();

        // Rest of your code
        Thread.sleep(5000);
        WebElement searchBox = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        actions.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
        actions.doubleClick().build().perform();

        // Close the browser
        driver.quit();
    }
}
