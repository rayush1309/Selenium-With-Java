package locatorsDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomisedCssSelector {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        //using tagName and id
        //driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("MacBook");
        //using tagName and attribute
      //  driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Macbook");
        //using class and attribute as well if we have multiple attriblte or class name with same name
        driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("macbook");

    }
}
