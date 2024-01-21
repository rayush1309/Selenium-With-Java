package locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AmazonGetLanguageList {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.amazon.in");
        driver.manage().window().maximize();

        Actions ac = new Actions(driver);
        WebElement element = driver.findElement(By.id("icp-nav-flyout"));
        ac.moveToElement(element).build().perform();

        // Trigger the dropdown to load using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        // Wait for the language options to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        System.out.println("Before WebDriverWait");
        List<WebElement> languages = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@id='nav-flyout-icp']//a[@class='nav-link']/span[@class='nav-text']")
        ));

        // Print the language options
        for (WebElement language : languages) {
            System.out.println(language.getText());
        }

        // Close the browser
        driver.quit();
    }
}
