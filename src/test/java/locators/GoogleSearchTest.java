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

public class GoogleSearchTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        // Enter the search query
        driver.findElement(By.name("q")).sendKeys("Tek");

        // Explicit wait for the suggestions to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> suggestions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']")
        ));

        // Print the search suggestions
        for (WebElement suggestion : suggestions) {
            System.out.println(suggestion.getText());
        }

        // Close the browser
        driver.quit();
    }
}
/*
Certainly! Let's break down the provided XPath expression step by step:

//ul[@role='listbox']: This part selects any ul element anywhere in the document that has an attribute role set to 'listbox'. The // indicates that the ul element can be located anywhere in the HTML hierarchy.

//li: This part selects any li element that is a descendant of the previously selected ul element. Again, the // means it can be anywhere below the ul.

descendant::div: This part selects any div element that is a descendant of the previously selected li. The descendant:: axis is used to specify that we want to select div elements that are descendants, not just direct children.

[@class='wM6W7d']: This part filters the div elements based on the condition that they must have a class attribute set to 'wM6W7d'.


 */