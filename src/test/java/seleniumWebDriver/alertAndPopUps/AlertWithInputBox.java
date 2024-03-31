package seleniumWebDriver.alertAndPopUps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertWithInputBox {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
        Alert alert=driver.switchTo().alert();
        String text= alert.getText();
        System.out.println(text);
        alert.sendKeys("Welcome");
        alert.accept();
        //Validation
       String actualText= driver.findElement(By.xpath("//p[@id='result']")).getText();
       String exptectedText="You entered: Welcome";
       if (actualText.equals(exptectedText)){
           System.out.println("Test Pass");
       }else {
           System.out.println("Test Failed");
       }









    }
}
