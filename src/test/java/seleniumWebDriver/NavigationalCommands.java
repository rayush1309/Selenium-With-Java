package seleniumWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommands {
    public static void main(String[] args) {
        /*
        navigate().to(url)--> same as driver.get()
        navigate().Forward()
        navigate().Back()
        navigate().refresh()
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.amazon.in/"); //or
        driver.navigate().to("https://www.amazon.in/");
        System.out.println(driver.getCurrentUrl());
        //driver.get("https://www.flipkart.com/");//or
        driver.navigate().to("https://www.flipkart.com/");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());//amazon
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());//flipkart
        driver.navigate().refresh(); //reload/refresh the page







    }
}
