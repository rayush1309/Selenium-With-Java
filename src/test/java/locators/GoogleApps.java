import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleApps {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        // Click on the "Apps" link at the bottom right
        WebElement appsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='Google apps']")));
        appsLink.click();
        // Find the iframe by name attribute
        WebElement iframe = driver.findElement(By.name("app"));

        // Switch to the iframe
        driver.switchTo().frame(iframe);

        // Wait for the app elements to be present
        // Wait for the app elements to be present
        List<WebElement> appElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//ul/li[@class='j1ei8c']")));

// Find and print all the app names
        for (WebElement appElement : appElements) {
            String appName = appElement.getText();
            System.out.println(appName);
        }


        // Close the browser window
        driver.quit();
    }
}
