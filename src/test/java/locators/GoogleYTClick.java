package locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleYTClick {
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
        List<WebElement> appElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//ul/li[@class='j1ei8c']")));

        // Find and click on the YouTube app
        for (WebElement appElement : appElements) {
            String appName = appElement.getText();
            if (appName.equalsIgnoreCase("YouTube")) {
                appElement.click();
                // Wait for the new content to load (adjust the time accordingly)
                Thread.sleep(5000); // You can use a WebDriverWait here for a more robust solution
                System.out.println(driver.getTitle()); // Print the title of the new page
                break; // Break out of the loop after clicking on YouTube
            }
        }

        // Close the browser window
        driver.quit();
    }
}
