package masterselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AddingitemsintoCart {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        driver.manage().window().maximize();
        List<WebElement> products =driver.findElements(By.cssSelector("h4.product-name"));
        for(int i=0;i<products.size();i++) {
            String name=products.get(i).getText();
            if(name.contains("Cucumber")) {
                //click on Add to Cart
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                break;
                //but if we have to Add 10 product we can not write for loop for each product for that we will Add the desired product in Array.
            }
        }
    }
}
