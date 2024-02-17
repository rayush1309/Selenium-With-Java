package redifftest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestWal {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.t-mobile.com/cell-phones");
        driver.manage().window().maximize();

        // Example: Filter by brand
        List<WebElement> filteredByBrand = filterByBrand(driver, "Samsung");

        // Perform actions on the filtered elements
        for (WebElement element : filteredByBrand) {
            // Perform your desired actions here
            System.out.println("Filtered by Brand: " + element.getText());
        }


    }

    public static List<WebElement> filterByBrand(WebDriver driver, String brandName) {
        // Construct the By locator for elements related to the specified brand
        By locator = By.xpath("//div[contains(@class, 'product') and contains(@class, 'brand') and text()='" + brandName + "']");

        // Find the matching elements
        List<WebElement> filteredElements = driver.findElements(locator);

        for (WebElement element : filteredElements) {
            System.out.println("element.getText() = " + element.getText());
        }

        return filteredElements;  // Return the list of filtered elements
    }
}
