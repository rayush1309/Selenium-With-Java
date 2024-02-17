package parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParameterTest {
    WebDriver driver;
    @Test
    public void loginYahooTest(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://login.yahoo.com");
        driver.findElement(By.xpath("//*[@id='login-username']")).clear();


    }
}
