package locatorsDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo1 {
    static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

        // Open app
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().window().maximize();

        // Interact with the page; search box
        driver.findElement(By.id("search_query_top")).sendKeys("T-shirt");

        //search Button
        driver.findElement(By.name("submit_search")).click();

        //Link text
       // driver.findElement(By.linkText("Printed Chiffon Dress")).click();

        //Partial linK Text
        driver.findElement(By.partialLinkText("Printed")).click();


        // Close the browser
        tearDown();


    }

    public static  void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
