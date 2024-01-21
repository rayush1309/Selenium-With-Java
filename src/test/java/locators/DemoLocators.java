package locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoLocators {
    public static void main(String[] args) throws InterruptedException {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("raysshtest");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.id("pass")));

        passwordField.sendKeys("ayush123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();


    }
}
