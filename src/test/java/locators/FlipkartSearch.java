package locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FlipkartSearch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@class='Pke_EE' and @name='q']")).sendKeys("macbook");

        // Wait for the search results to load (you can use WebDriverWait)
        try {
            Thread.sleep(3000);  // Wait for 3 seconds (you should use WebDriverWait instead)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> itemList = driver.findElements(By.xpath("//ul[contains(@class, '_1sFryS')]//li[contains(@class, '_3D0G9a')]"));
        for (WebElement item : itemList) {
            String name = item.getText();
            System.out.println(name);
        }


    }
    }


