package locatorsDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomisedXpath {
    public static void main(String[] args) {
        //div[contains(text(),'MacBook')]
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        String prodName=driver.findElement(By.xpath("//a[(text()='MacBook')]")).getText();
        //normalize space
        String element = driver.findElement(By.xpath("//a[normalize-space()='MacBook']")).getText();
        System.out.println(prodName);
        System.out.println(element);


    }
}
