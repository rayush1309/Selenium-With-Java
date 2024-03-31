package seleniumWebDriver.alertAndPopUps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingAlerts {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
        //Alert alertWindow=driver.switchTo().alert(); //or
        //driver.switchTo().alert().accept();
        Alert alertWindow= wait.until(ExpectedConditions.alertIsPresent());
        String alertText=alertWindow.getText();
        System.out.println(alertText);
       // alertWindow.accept();//This will close Alert window using ok Button
        alertWindow.dismiss();//close Alert window by cancel Button






    }

}
