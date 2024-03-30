package seleniumWebDriver.checkBoxesAndDropDowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkBoxesDemo1 {
    public static void main(String[] args) {
        //https://itera-qa.azurewebsites.net/home/automation
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://itera-qa.azurewebsites.net/home/automation");

    }
}
