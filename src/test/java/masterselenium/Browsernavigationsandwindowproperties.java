package masterselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browsernavigationsandwindowproperties {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");

        // Use JavaScript to open a new tab
        ((JavascriptExecutor) driver).executeScript("window.open()");

        // Switch to the new tab
        String newTab = driver.getWindowHandles().toArray()[1].toString();
        driver.switchTo().window(newTab);

        // Navigate to "https://rahulshettyacademy.com"
        driver.navigate().to("https://rahulshettyacademy.com");

        // Navigate back and forward
        driver.navigate().back();
        driver.navigate().forward();

        // Close the browser
        driver.quit();
    }
}
