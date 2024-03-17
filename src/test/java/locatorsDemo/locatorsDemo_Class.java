package locatorsDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class locatorsDemo_Class {
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Open app
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().window().maximize();

        //finding Number of Sliders on the Home Page
        List<WebElement> sliders = driver.findElements(By.className("homeslider-container"));
        System.out.println("Number of Sliders:" + sliders.size());

        //find the total number of Images in the home page;
        List<WebElement> totalImages= driver.findElements(By.tagName("img"));
        System.out.println("Total Number of images is : "+ totalImages.size());


        //close the browser
        tearDown();


    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}