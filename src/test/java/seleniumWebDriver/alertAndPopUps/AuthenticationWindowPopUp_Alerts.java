package seleniumWebDriver.alertAndPopUps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthenticationWindowPopUp_Alerts {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        //https://the-internet.herokuapp.com/basic_auth
        //we need to by pass userName and Password along with url
        //syntax: http://admin:admin@the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        driver.manage().window().maximize();
        String text=driver.findElement(By.xpath("//p[contains(text(),'Congratulations!')]")).getText();
        if (text.contains("Congratulations")){
            System.out.println("Successful Login");
        }else {
            System.out.println("Login Failed");
        }

    }
}
